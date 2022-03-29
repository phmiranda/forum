/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.response.UsuarioResponseDto;
import br.com.phmiranda.comunidade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDto> index() {
        return usuarioService.index();
    }

    @GetMapping("/filtro/{id}")
    public List<UsuarioResponseDto> pesquisarPorId(Long id) {
        return usuarioService.pesquisarPorId(id);
    }

    @GetMapping("/filtro/nome")
    public List<UsuarioResponseDto> pesquisarPorNome(String nome) {
        return usuarioService.pesquisarPorNome(nome);
    }

    @GetMapping("/filtro/email")
    public List<UsuarioResponseDto> pesquisarPorEmail(String email) {
        return usuarioService.pesquisarPorEmail(email);
    }

    @GetMapping("/filtro/documento")
    public List<UsuarioResponseDto> pesquisarPorDocumento(String documento) {
        return usuarioService.pesquisarPorDocumento(documento);
    }

    @GetMapping("/filtro/status")
    public List<UsuarioResponseDto> pesquisarStatusUsuario(String usuarioStatus) {
        return usuarioService.pesquisarPorStatus(usuarioStatus);
    }
}
