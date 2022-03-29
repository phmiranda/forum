/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 29/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.domain.dto.response.RespostaResponseDto;
import br.com.phmiranda.comunidade.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {



    @Autowired
    RespostaRepository respostaRepository;

    public List<RespostaResponseDto> index() {
        List<Resposta> respostas = respostaRepository.findAll();
        return RespostaResponseDto.converter(respostas);
    }

    public List<RespostaResponseDto> pesquisarPorId(Long id){
        // List<Resposta> respostas = respostaRepository.findById(id);
        // return RespostaResponseDto.converter(respostas);
        return null;
    }

    public List<RespostaResponseDto> pesquisarPorDuvida(String duvida) {
        List<Resposta> respostas = respostaRepository.findByDuvidaTitulo(duvida);
        return RespostaResponseDto.converter(respostas);
    }

    public List<RespostaResponseDto> pesquisarPorUsuario(String usuario) {
        List<Resposta> respostas = respostaRepository.findByUsuarioNome(usuario);
        return RespostaResponseDto.converter(respostas);
    }

    public List<RespostaResponseDto> pesquisarPorSituacao(String situacao) {
        List<Resposta> respostas = respostaRepository.findBySituacao(situacao);
        return RespostaResponseDto.converter(respostas);
    }
}
