/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU003
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE TÓPICOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.Topico;
import br.com.phmiranda.comunidade.domain.dto.TopicoDetalharDto;
import br.com.phmiranda.comunidade.domain.dto.TopicoDto;
import br.com.phmiranda.comunidade.domain.form.TopicoAtualizarFormDto;
import br.com.phmiranda.comunidade.domain.form.TopicoFormDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import br.com.phmiranda.comunidade.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public Page<TopicoDto> index(@PageableDefault(sort = "id", page = 0, size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Topico> topicos = topicoRepository.findAll(paginacao);
        return TopicoDto.converter(topicos);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoFormDto topicoFormDto, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoFormDto.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody TopicoAtualizarFormDto topicoAtualizarFormDto) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()){
            Topico topico = topicoAtualizarFormDto.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalharDto> pesquisarPorId(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            return ResponseEntity.ok(new TopicoDetalharDto(optionalTopico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria")
    public Page<TopicoDto> pesquisarPorNomeDoCurso(@RequestParam(required = true) String nomeCurso, @PageableDefault(sort = "id", page = 0, size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
        return TopicoDto.converter(topicos);
    }
}
