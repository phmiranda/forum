/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.RespostaRequest;
import br.com.phmiranda.comunidade.domain.dto.request.RespostaUpdateRequest;
import br.com.phmiranda.comunidade.domain.dto.response.RespostaResponse;
import br.com.phmiranda.comunidade.service.RespostaService;
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
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    RespostaService respostaService;

    @GetMapping
    public Page<RespostaResponse> listar(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        return respostaService.index(paginacao);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<RespostaResponse> cadastrar(@RequestBody @Valid RespostaRequest respostaRequest, UriComponentsBuilder uriComponentsBuilder) {
        return respostaService.salvar(respostaRequest, uriComponentsBuilder);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<RespostaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid RespostaUpdateRequest respostaUpdateRequest) {
        return respostaService.atualizar(id, respostaUpdateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaResponse> detalhar(@PathVariable Long id) {
        return respostaService.pesquisarPorId(id);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return respostaService.deletar(id);
    }
}
