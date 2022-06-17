/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.UsuarioUpdateRequest;
import br.com.phmiranda.comunidade.domain.dto.request.UsuarioRequest;
import br.com.phmiranda.comunidade.domain.dto.response.UsuarioResponse;
import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Page<UsuarioResponse> index(Pageable paginacao) {
        Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
        return UsuarioResponse.converter(usuarios);
    }

    public ResponseEntity<UsuarioResponse> salvar(UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRequest.converter();
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }

    public ResponseEntity<UsuarioResponse> atualizar(Long id, UsuarioUpdateRequest usuarioUpdateRequest) {
        Usuario usuario = usuarioUpdateRequest.atualizarEntidade(id, usuarioRepository);
        return ResponseEntity.ok(new UsuarioResponse(usuario));
    }

    public UsuarioResponse pesquisarPorId(Long id) {
        Usuario usuario = usuarioRepository.getOne(id);
        return new UsuarioResponse(usuario);
    }

    public ResponseEntity<?> deletar(Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
