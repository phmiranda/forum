/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU06 - AUTENTICAÇÃO DA API.
 * Description: DESENVOLVIMENTO DO FLUXO DE AUTENTICAÇÃO DA API.
 * Date: 01/07/2021
 */

package br.com.phmiranda.comunidade.util;

import br.com.phmiranda.comunidade.domain.Usuario;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import br.com.phmiranda.comunidade.service.UsuarioAuthTokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class UsuarioTokenFiltro extends OncePerRequestFilter {

    private UsuarioAuthTokenService usuarioAuthTokenService;
    private UsuarioRepository usuarioRepository;

    public UsuarioTokenFiltro(UsuarioAuthTokenService usuarioAuthTokenService, UsuarioRepository usuarioRepository) {
        this.usuarioAuthTokenService = usuarioAuthTokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        Boolean tokenValidado = usuarioAuthTokenService.isTokenValido(token);
        if (tokenValidado) {
            autenticarUsuario(token);
        }
        System.out.println("TOKEN ESTÁ VÁLIDO: " + tokenValidado);
        filterChain.doFilter(request, response);
    }

    private void autenticarUsuario(String token) {
        Long idUsuario = usuarioAuthTokenService.getIdUsuario(token);
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,  null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
