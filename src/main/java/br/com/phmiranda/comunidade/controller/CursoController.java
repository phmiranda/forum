/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.CursoRequestDto;
import br.com.phmiranda.comunidade.domain.dto.response.CursoResponseDto;
import br.com.phmiranda.comunidade.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrar(@RequestBody CursoRequestDto cursoRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        return cursoService.salvar(cursoRequestDto, uriComponentsBuilder);
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
