/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.response.CursoResponseDto;
import br.com.phmiranda.comunidade.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<CursoResponseDto> index() {
        return  cursoService.index();
    }

    @GetMapping("/filtro/{id}")
    public List<CursoResponseDto> pesquisarPorId(Long id) {
        return cursoService.pesquisarPorId(id);
    }

    @GetMapping("/filtro/nome")
    public List<CursoResponseDto> pesquisarPorNome(String nome) {
        return cursoService.pesquisarPorNome(nome);
    }

    @GetMapping("/filtro/categoria")
    public List<CursoResponseDto> pesquisarPorCategoria(String categoria) {
        return cursoService.pesquisarPorCategoria(categoria);
    }
}
