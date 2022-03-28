/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.domain.dto.response.CursoResponseDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<CursoResponseDto> index() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoResponseDto.converter(cursos);
    }
}
