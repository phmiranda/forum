/**
 * User: phmiranda
 * Project: forum
 * Date: 05/05/2020
 */

package br.com.alura.comunidade.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String olaMundo(){
        return  "Olá Mundo, vamos aprender Spring Boot ?";
    }
}
