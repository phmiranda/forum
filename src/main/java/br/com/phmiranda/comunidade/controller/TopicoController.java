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
import br.com.phmiranda.comunidade.domain.form.TopicoAtualizarForm;
import br.com.phmiranda.comunidade.domain.form.TopicoFormDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import br.com.phmiranda.comunidade.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> index() {
        List<Topico> topicos = topicoRepository.findAll();
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
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody TopicoAtualizarForm topicoAtualizarForm) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()){
            Topico topico = topicoAtualizarForm.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalharDto> pesquisarPorId(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            return ResponseEntity.ok(new TopicoDetalharDto(topicoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categorias")
    public List<TopicoDto> pesquisarPorNomeDoCurso(String nomeCurso) {
        List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
        return TopicoDto.converter(topicos);
    }
}
