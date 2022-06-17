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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public Page<CursoResponse> listar(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        return  cursoService.index(paginacao);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CursoResponse> cadastrar(@RequestBody @Valid CursoRequest cursoRequest, UriComponentsBuilder uriComponentsBuilder) {
        return cursoService.salvar(cursoRequest, uriComponentsBuilder);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid CursoRequest cursoRequest) {
        return cursoService.atualizar(id, cursoRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> detalhar(@PathVariable Long id) {
        return cursoService.pesquisarPorId(id);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return cursoService.deletar(id);
    }

    @GetMapping("/filtro/categoria")
    public Page<CursoResponse> pesquisarPorCategoria(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao, @RequestParam(required = false) String categoria) {
        return cursoService.pesquisarPorCategoria(paginacao, categoria);
    }
}
