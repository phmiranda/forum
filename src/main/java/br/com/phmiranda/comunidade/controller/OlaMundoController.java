/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU001
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE USUÁRIOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/ola")
public class OlaMundoController {
    @GetMapping
    public ResponseEntity<?> olaMundo(@PathParam("nome") String nome) {
        System.out.println("OLÁ " + nome + ",BEM VINDO AO CURSO DE SPRING BOOT !");
        return ResponseEntity.ok().build();
    }
}