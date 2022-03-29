/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 71
 * Description: Introdução ao Spring Boot
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/logar")
    public void autenticar() {
        System.out.println("AUTENTICANDO USUÁRIO: ");
    }

    @PostMapping("/deslogar")
    public void deslogar() {
        System.out.println("DESLOGANDO USUÁRIO: ");
    }

    @PostMapping("/oauth/google")
    public void oAuthGoogle() {
        System.out.println("AUTENTICANDO USUÁRIO NO GOOGLE OAUTH2: ");
    }

    @PostMapping("/oauth/facebook")
    public void oAuthFacebook() {
        System.out.println("AUTENTICANDO USUÁRIO NO FACEBOOK: ");
    }
}
