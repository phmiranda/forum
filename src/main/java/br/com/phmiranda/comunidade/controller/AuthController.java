/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 71
 * Description: Introdução ao Spring Boot
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.UsuarioRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/basica")
    public void autenticar(@RequestBody UsuarioRequest usuarioRequest) {
        System.out.println("AUTENTICANDO USUÁRIO: " + usuarioRequest.getEmail());
    }

    @PostMapping("/deslogar")
    public void deslogar() {
        System.out.println("DESLOGANDO USUÁRIO: ");
    }

    @PostMapping("/oauth/google")
    public void oAuthGoogle(@RequestBody UsuarioRequest usuarioRequest) {
        System.out.println("AUTENTICANDO USUÁRIO NO GOOGLE OAUTH2: " + usuarioRequest.getEmail());
    }

    @PostMapping("/oauth/facebook")
    public void oAuthFacebook(@RequestBody UsuarioRequest usuarioRequest) {
        System.out.println("AUTENTICANDO USUÁRIO NO FACEBOOK: " + usuarioRequest.getEmail());
    }
}
