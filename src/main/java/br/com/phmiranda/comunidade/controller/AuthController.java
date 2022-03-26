/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @PostMapping("/autenticar")
    public void autenticar() {
        System.out.println("AUTENTICANDO USUÁRIO: ");
    }

    @PostMapping("/deslogar")
    public void deslogar() {
        System.out.println("DESLOGANDO USUÁRIO: ");
    }
}
