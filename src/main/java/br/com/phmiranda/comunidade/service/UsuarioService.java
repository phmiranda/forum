/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.UsuarioRequest;
import br.com.phmiranda.comunidade.domain.dto.response.UsuarioResponse;
import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> index() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioResponse.converter(usuarios);
    }

    public ResponseEntity<UsuarioResponse> salvar(UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRequest.converter();
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }
}
