/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.DuvidaUpdateRequest;
import br.com.phmiranda.comunidade.domain.dto.request.DuvidaRequest;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaDetalharResponse;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaResponse;
import br.com.phmiranda.comunidade.service.DuvidaService;
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
import java.util.List;

@RestController
@RequestMapping("/duvidas")
public class DuvidaController {

    @Autowired
    DuvidaService duvidaService;

    @GetMapping
    public Page<DuvidaResponse> listar(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        return duvidaService.index(paginacao);
    }

    @Transactional
    @PostMapping

    public ResponseEntity<DuvidaResponse> cadastrar(@RequestBody @Valid DuvidaRequest duvidaRequest, UriComponentsBuilder uriComponentsBuilder) {
        return duvidaService.salvar(duvidaRequest, uriComponentsBuilder);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<DuvidaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid DuvidaUpdateRequest duvidaUpdateRequest) {
        return duvidaService.atualizar(id, duvidaUpdateRequest);
    }

    @GetMapping("/{id}")
    public DuvidaDetalharResponse detalhar(@PathVariable Long id) {
        return duvidaService.pesquisarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return duvidaService.deletar(id);
    }
}
