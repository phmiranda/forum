/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU3 - CADASTRO DO RECURSO DE TÓPICOS
 * Description: CONSTRUÇÃO DO ENDPOINT REFERENTE AO RECURSO DE TÓPICOS
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.TopicoAtualizarDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoCadastrarDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoDetalharDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoDto;
import br.com.phmiranda.comunidade.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    @Cacheable(value = "topicos-lista")
    public Page<TopicoDto> index(@PageableDefault(page = 0, size = 10, sort = "id",direction = Sort.Direction.DESC) Pageable paginacao) {
        return topicoService.index(paginacao);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "topicos-lista", allEntries = true)
    public ResponseEntity<TopicoDto> cadastrarTopico(@RequestBody @Valid TopicoCadastrarDto topicoCadastrarDto, UriComponentsBuilder uriComponentsBuilder) {
        ResponseEntity<TopicoDto> topicoDtoResponseEntity = topicoService.salvarTopico(topicoCadastrarDto, uriComponentsBuilder);
        return topicoDtoResponseEntity;
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicos-lista", allEntries = true)
    public ResponseEntity<TopicoDto> atualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoAtualizarDto topicoAtualizarDto) {
        return topicoService.atualizarInformacaoTopico(id, topicoAtualizarDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicos-lista", allEntries = true)
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        return topicoService.excluirTopico(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalharDto> detalharTopico(@PathVariable Long id) {
        return topicoService.detalharInformacaoTopico(id);
    }

    @GetMapping("/nome-do-curso")
    public Page<TopicoDto> pesquisarTopicoPorCurso(@RequestParam String nomeCurso,@PageableDefault(page = 0, size = 10) Pageable paginacao) {
        return topicoService.findByCursoNome(nomeCurso, paginacao);
    }
}
