/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 28/06/2021
 */
package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.Usuario;
import br.com.phmiranda.comunidade.domain.dto.UsuarioDto;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> index() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDto.converterUsuarioDtoParaEntidade(usuarios);
    }
}
