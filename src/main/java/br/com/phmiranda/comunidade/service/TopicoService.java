/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU3 - CADASTRO DO RECURSO DE TÓPICOS
 * Description: CONSTRUÇÃO DO ENDPOINT REFERENTE AO RECURSO DE TÓPICOS
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.Topico;
import br.com.phmiranda.comunidade.domain.dto.TopicoAtualizarDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoCadastrarDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoDetalharDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import br.com.phmiranda.comunidade.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Page<TopicoDto> index(Pageable paginacao) {
        Page<Topico> topicos = topicoRepository.findAll(paginacao);
        return TopicoDto.converterTopicoDtoParaEntidade(topicos);
    }

    public ResponseEntity<TopicoDto> salvarTopico(TopicoCadastrarDto topicoCadastrarDto, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoCadastrarDto.converterTopicoDtoParaEntidade(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    public ResponseEntity<TopicoDetalharDto> detalharInformacaoTopico(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            return ResponseEntity.ok(new TopicoDetalharDto(optionalTopico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<TopicoDto> atualizarInformacaoTopico(Long id, TopicoAtualizarDto topicoAtualizarDto) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = topicoAtualizarDto.atualizarInformacaoNoTopico(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity excluirTopico(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public Page<TopicoDto> findByCursoNome(String nomeCurso, Pageable paginacao) {
        Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
        return TopicoDto.converterTopicoDtoParaEntidade(topicos);
    }
}
