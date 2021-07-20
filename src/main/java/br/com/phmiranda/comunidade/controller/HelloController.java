/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU001
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE USUÁRIOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola-mundo")
public class HelloController {
    @RequestMapping
    public String olaMundo(String nome) {

        return "Olá "+ nome +", vamos aprender Spring Boot ?";
    }
}
