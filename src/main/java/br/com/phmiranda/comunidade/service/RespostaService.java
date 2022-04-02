/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 29/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.RespostaRequestDto;
import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.domain.dto.response.RespostaResponseDto;
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

    public List<RespostaResponseDto> index() {
        List<Resposta> respostas = respostaRepository.findAll();
        return RespostaResponseDto.converter(respostas);
    }

    public ResponseEntity<RespostaResponseDto> salvar(RespostaRequestDto respostaRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        Resposta resposta = respostaRequestDto.converter(usuarioRepository, duvidaRepository);
        respostaRepository.save(resposta);
        URI uri = uriComponentsBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaResponseDto(resposta));
    }

    public List<RespostaResponseDto> pesquisarPorId(Long id){
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
