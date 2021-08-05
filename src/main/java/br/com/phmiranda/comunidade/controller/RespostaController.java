/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 03/08/2021
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.Resposta;
import br.com.phmiranda.comunidade.domain.dto.RespostaDto;
import br.com.phmiranda.comunidade.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    RespostaRepository respostaRepository;

    @GetMapping
    public List<RespostaDto> index() {
        List<Resposta> respostas = respostaRepository.findAll();
        return RespostaDto.converter(respostas);
    }


    @PostMapping
    @Transactional
    public void cadastrar() {

    }
}
