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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ola-mundo")
public class HelloController {
    @RequestMapping
    public List<?> olaMundo() {
        List<String> mensagem = new ArrayList<>();
        mensagem.add("Olá, bem vindo ao curso de SPRING BOOT.");
        return Arrays.asList(mensagem, mensagem);
    }
}
