/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 28/06/2021
 */
package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.Resposta;
import br.com.phmiranda.comunidade.domain.dto.RespostaDto;
import br.com.phmiranda.comunidade.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    public List<RespostaDto> index() {
        List<Resposta> respostas = respostaRepository.findAll();
        return RespostaDto.converterRespostaDtoParaEntidade(respostas);
    }
}
