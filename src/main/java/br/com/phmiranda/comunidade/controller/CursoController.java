/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 03/08/2021
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.domain.dto.CursoDetalharDto;
import br.com.phmiranda.comunidade.domain.dto.CursoDto;
import br.com.phmiranda.comunidade.domain.form.CursoFormDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto> index() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converter(cursos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoFormDto cursoFormDto, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoFormDto.converter();
        cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }

    @GetMapping("/{id}")
    public CursoDetalharDto detalhar(@PathVariable Long id) {
        Curso curso = cursoRepository.getOne(id);
        return new CursoDetalharDto(curso);
    }
}
