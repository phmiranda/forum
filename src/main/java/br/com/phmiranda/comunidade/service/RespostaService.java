/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.RespostaRequest;
import br.com.phmiranda.comunidade.domain.dto.response.RespostaResponse;
import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.repository.DuvidaRepository;
import br.com.phmiranda.comunidade.repository.RespostaRepository;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class RespostaService {

    @Autowired
    RespostaRepository respostaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    DuvidaRepository duvidaRepository;

    public List<RespostaResponse> index() {
        List<Resposta> respostas = respostaRepository.findAll();
        return RespostaResponse.converter(respostas);
    }

    public ResponseEntity<RespostaResponse> salvar(RespostaRequest respostaRequest, UriComponentsBuilder uriComponentsBuilder) {
        Resposta resposta = respostaRequest.converter(usuarioRepository, duvidaRepository);
        respostaRepository.save(resposta);
        URI uri = uriComponentsBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaResponse(resposta));
    }
}
