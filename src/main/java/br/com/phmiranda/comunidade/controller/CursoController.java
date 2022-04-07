/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.CursoRequest;
import br.com.phmiranda.comunidade.domain.dto.response.CursoResponse;
import br.com.phmiranda.comunidade.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<CursoResponse> index() {
        return  cursoService.index();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CursoResponse> cadastrar(@RequestBody @Valid CursoRequest cursoRequest, UriComponentsBuilder uriComponentsBuilder) {
        return cursoService.salvar(cursoRequest, uriComponentsBuilder);
    }

    @GetMapping("/filtro/{id}")
    public List<CursoResponse> pesquisarPorId(Long id) {
        return cursoService.pesquisarPorId(id);
    }

    @GetMapping("/filtro/categoria")
    public List<CursoResponse> pesquisarPorCategoria(String categoria) {
        return cursoService.pesquisarPorCategoria(categoria);
    }
}
