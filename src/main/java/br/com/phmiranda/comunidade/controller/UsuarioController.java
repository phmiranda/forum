/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.UsuarioUpdateRequest;
import br.com.phmiranda.comunidade.domain.dto.request.UsuarioRequest;
import br.com.phmiranda.comunidade.domain.dto.response.UsuarioResponse;
import br.com.phmiranda.comunidade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponse> listar() {
        return usuarioService.index();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder) {
        return usuarioService.salvar(usuarioRequest, uriComponentsBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateRequest usuarioUpdateRequest) {
        return usuarioService.atualizar(id, usuarioUpdateRequest);
    }

    @GetMapping("/{id}")
    public UsuarioResponse detalhar(@PathVariable Long id) {
        return usuarioService.pesquisarPorId(id);
    }
}
