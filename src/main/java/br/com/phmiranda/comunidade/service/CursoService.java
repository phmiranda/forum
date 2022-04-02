/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.CursoRequestDto;
import br.com.phmiranda.comunidade.domain.entity.Curso;
import br.com.phmiranda.comunidade.domain.dto.response.CursoResponseDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CursoService {


    @Autowired
    CursoRepository cursoRepository;

    public List<CursoResponseDto> index() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoResponseDto.converter(cursos);
    }

    public ResponseEntity<CursoResponseDto> salvar(CursoRequestDto cursoRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRequestDto.converter();
        cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoResponseDto(curso));
    }

    public List<CursoResponseDto> pesquisarPorId(Long id) {
        return null;
    }

    public List<CursoResponseDto> pesquisarPorNome(String nome) {
        List<Curso> cursos = cursoRepository.findByNome(nome);
        return CursoResponseDto.converter(cursos);
    }

    public List<CursoResponseDto> pesquisarPorCategoria(String categoria) {
        List<Curso> cursos = cursoRepository.findByCategoria(categoria);
        return CursoResponseDto.converter(cursos);
    }
}
