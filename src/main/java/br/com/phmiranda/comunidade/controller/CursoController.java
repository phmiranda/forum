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
    public Page<CursoResponse> listar(@RequestParam Integer pagina, @RequestParam Integer elementos, @RequestParam(required = false) String ordenacao) {
        return  cursoService.index(pagina, elementos, ordenacao);
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
    public Page<CursoResponse> pesquisarPorCategoria(@RequestParam Integer pagina, @RequestParam Integer elementos, @RequestParam(required = false) String ordenacao, @RequestParam String categoria) {
        return cursoService.pesquisarPorCategoria(pagina, elementos, ordenacao, categoria);
    }
}
