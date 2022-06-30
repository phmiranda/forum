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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    @Cacheable(value = "listaDeUsuarios")
    public Page<UsuarioResponse> listar(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        return usuarioService.index(paginacao);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeUsuarios", allEntries = true)
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder) {
        return usuarioService.salvar(usuarioRequest, uriComponentsBuilder);
    }

    @Transactional
    @PutMapping("/{id}")
    @CacheEvict(value = "listaDeUsuarios", allEntries = true)
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateRequest usuarioUpdateRequest) {
        return usuarioService.atualizar(id, usuarioUpdateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> detalhar(@PathVariable Long id) {
        return usuarioService.pesquisarPorId(id);
    }

    @Transactional
    @DeleteMapping("/{id}")
    @CacheEvict(value = "listaDeUsuarios", allEntries = true)
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return usuarioService.deletar(id);
    }
}
