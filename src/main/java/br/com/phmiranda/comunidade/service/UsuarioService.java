/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.UsuarioRequestDto;
import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.domain.dto.response.UsuarioResponseDto;
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

    public List<UsuarioResponseDto> index() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioResponseDto.converter(usuarios);
    }

    public ResponseEntity<UsuarioResponseDto> salvar(UsuarioRequestDto usuarioRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRequestDto.converter();
        usuario.setSenha("$2a$04$PeKdrLpYfR3Z8A2qZ5ekneDIRp8x4ORiz/oKu9Ird2uX.RbaFHj4u");
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponseDto(usuario));
    }

    public List<UsuarioResponseDto> pesquisarPorId(Long id) {
        return null;
    }

    public List<UsuarioResponseDto> pesquisarPorNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.findByNome(nome);
        return UsuarioResponseDto.converter(usuarios);
    }

    public List<UsuarioResponseDto> pesquisarPorEmail(String email) {
        List<Usuario> usuarios = usuarioRepository.findByEmail(email);
        return UsuarioResponseDto.converter(usuarios);
    }

    public List<UsuarioResponseDto> pesquisarPorDocumento(String documento) {
        List<Usuario> usuarios = usuarioRepository.findByDocumento(documento);
        return UsuarioResponseDto.converter(usuarios);
    }

    public List<UsuarioResponseDto> pesquisarPorStatus(String usuarioStatus) {
        return null;
    }
}
