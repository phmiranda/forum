/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 03/08/2021
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.domain.Topico;
import br.com.phmiranda.comunidade.domain.dto.CursoDetalharDto;
import br.com.phmiranda.comunidade.domain.dto.CursoDto;
import br.com.phmiranda.comunidade.domain.form.CursoAtualizarFormDto;
import br.com.phmiranda.comunidade.domain.form.CursoFormDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public Page<CursoDto> index(@PageableDefault(sort = "id", page = 0, size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Curso> cursos = cursoRepository.findAll(paginacao);
        return CursoDto.converter(cursos);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoFormDto cursoFormDto, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoFormDto.converter();
        cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            cursoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody CursoAtualizarFormDto cursoAtualizarFormDto) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            Curso curso = cursoAtualizarFormDto.atualizarRecurso(id, cursoRepository);
            return ResponseEntity.ok(new CursoDto(curso));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDetalharDto> pesquisarPorId(@PathVariable Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            return ResponseEntity.ok(new CursoDetalharDto(optionalCurso.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/nome")
    public Page<CursoDto> pesquisarPorNome(@RequestParam String nome) {
        return null;
    }

    @GetMapping("/categoria")
    public Page<CursoDto> pesquisarPorCategoria(@RequestParam String categoria) {
        return null;
    }
}
