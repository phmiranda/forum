/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 71
 * Description: Introdução ao Spring Boot
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.AuthRequest;
import br.com.phmiranda.comunidade.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/basica")
    public ResponseEntity<?> autenticacaoBasica(@RequestBody @Valid AuthRequest authRequest) {
        System.out.println(authRequest.getEmail());
        System.out.println(authRequest.getSenha());
        return authService.autenticar(authRequest);
    }
}
