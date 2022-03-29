/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.domain.dto.response.UsuarioResponseDto;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDto> index() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioResponseDto.converter(usuarios);
    }

    public List<UsuarioResponseDto> pesquisarPorId(Long id) {
        //List<Usuario> usuarios = usuarioRepository.findById(id);
        //return UsuarioResponseDto.converter(usuarios);
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
        //List<Usuario> usuarios = usuarioRepository.findByStatus(usuarioStatus);
        //return UsuarioResponseDto.converter(usuarios);
        return null;
    }
}
