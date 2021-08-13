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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    RespostaRepository respostaRepository;

    @GetMapping
    public Page<RespostaDto> index(@PageableDefault(sort = "id", page = 0, size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Resposta> respostas = respostaRepository.findAll(paginacao);
        return RespostaDto.converter(respostas);
    }


    @PostMapping
    @Transactional
    public void cadastrar() {

    }

    public void deletar() {

    }

    public void atualizar(){

    }

    public void pesquisarPorId(){

    }

    public void pesquisarPorNome(){

    }

    public void pesquisarPorEmail(){

    }

    public void pesquisarPorDocumento(){

    }
}
