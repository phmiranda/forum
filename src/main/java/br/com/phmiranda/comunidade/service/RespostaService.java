/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.RespostaRequest;
import br.com.phmiranda.comunidade.domain.dto.request.RespostaUpdateRequest;
import br.com.phmiranda.comunidade.domain.dto.response.RespostaResponse;
import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.repository.DuvidaRepository;
import br.com.phmiranda.comunidade.repository.RespostaRepository;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    RespostaRepository respostaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    DuvidaRepository duvidaRepository;

    public Page<RespostaResponse> index(Pageable paginacao) {
        Page<Resposta> respostas = respostaRepository.findAll(paginacao);
        return RespostaResponse.converter(respostas);
    }

    public ResponseEntity<RespostaResponse> salvar(RespostaRequest respostaRequest, UriComponentsBuilder uriComponentsBuilder) {
        Resposta resposta = respostaRequest.converter(usuarioRepository, duvidaRepository);
        respostaRepository.save(resposta);
        URI uri = uriComponentsBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaResponse(resposta));
    }

    public ResponseEntity<RespostaResponse> atualizar(Long id, RespostaUpdateRequest respostaUpdateRequest) {
        Resposta resposta = respostaUpdateRequest.atualizarEntidade(id, respostaRepository);
        return ResponseEntity.ok(new RespostaResponse(resposta));
    }

    public RespostaResponse pesquisarPorId(Long id) {
        Resposta resposta = respostaRepository.getOne(id);
        return new RespostaResponse(resposta);
    }

    public ResponseEntity<?> deletar(Long id) {
        Optional<Resposta> optional = respostaRepository.findById(id);
        if (optional.isPresent()){
            respostaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
