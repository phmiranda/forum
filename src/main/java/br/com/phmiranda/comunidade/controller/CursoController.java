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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @GetMapping
    public List<CursoResponseDto> index() {
        Curso cursos = new Curso("Curso de Java EE - Spring Boot Básico", "Programação");
        return CursoResponseDto.converter(Arrays.asList(cursos, cursos, cursos, cursos, cursos));
    }
}
