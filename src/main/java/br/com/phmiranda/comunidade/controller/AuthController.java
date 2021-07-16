/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU06 - AUTENTICAÇÃO DA API.
 * Description: DESENVOLVIMENTO DO FLUXO DE AUTENTICAÇÃO DA API.
 * Date: 01/07/2021
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.UsuarioAuthDto;
import br.com.phmiranda.comunidade.domain.dto.TokenDto;
import br.com.phmiranda.comunidade.service.UsuarioAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UsuarioAuthTokenService usuarioAuthTokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid UsuarioAuthDto usuarioAuthDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = usuarioAuthDto.converterAutenticacaoDtoParaEntidade();
        try {
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            String token = usuarioAuthTokenService.gerarToken(authentication);
            //System.out.println("TOKEN GERADO:" + token);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }catch (AuthenticationException exception){
            return ResponseEntity.badRequest().build();
        }

    }
}
