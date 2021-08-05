/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 03/08/2021
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.Usuario;
import br.com.phmiranda.comunidade.domain.dto.UsuarioDto;
import br.com.phmiranda.comunidade.domain.form.UsuarioFormDto;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDto> index() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDto.converter(usuarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioFormDto usuarioFormDto, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioFormDto.converter();
        // verifica a criptografia da senha de usuário e seta antes de persistir.
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }
}
