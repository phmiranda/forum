/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.DuvidaRequest;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaResponse;
import br.com.phmiranda.comunidade.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DuvidaResponse> index() {
        return duvidaService.index();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DuvidaResponse> cadastrar(@RequestBody @Valid DuvidaRequest duvidaRequest, UriComponentsBuilder uriComponentsBuilder) {
        return duvidaService.salvar(duvidaRequest, uriComponentsBuilder);
    }

    @GetMapping("/filtro/{id}")
    public void pesquisarPorId() {

    }
}
