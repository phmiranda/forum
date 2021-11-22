/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number (Nº): HUXXX
 * Description: N/A
 * Date: 22/09/2021
 */

package br.com.phmiranda.comunidade.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AuthController {
    @PostMapping
    public ResponseEntity<?> autenticar() {

        return ResponseEntity.ok().build();
    }
}
