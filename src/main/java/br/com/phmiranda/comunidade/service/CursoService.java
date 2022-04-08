/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.CursoRequest;
import br.com.phmiranda.comunidade.domain.entity.Curso;
import br.com.phmiranda.comunidade.domain.dto.response.CursoResponse;
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

    public List<CursoResponse> index() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoResponse.converter(cursos);
    }

    public ResponseEntity<CursoResponse> salvar(CursoRequest cursoRequest, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRequest.converter();
        cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoResponse(curso));
    }

    public CursoResponse pesquisarPorId(Long id) {
        Curso curso = cursoRepository.getOne(id);
        return new CursoResponse(curso);
    }

    public List<CursoResponse> pesquisarPorCategoria(String categoria) {
        List<Curso> cursos = cursoRepository.findByCategoria(categoria);
        return CursoResponse.converter(cursos);
    }
}
