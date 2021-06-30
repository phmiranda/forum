/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola")
public class HelloWorldController {
    @RequestMapping
    public String olaMundo(String nome){
        return "Olá "+ nome +", vamos aprender Spring Boot ?";
    }
}
