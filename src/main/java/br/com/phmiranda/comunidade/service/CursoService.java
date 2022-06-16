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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CursoService {


    @Autowired
    CursoRepository cursoRepository;

    public Page<CursoResponse> index(Pageable paginacao) {
        Page<Curso> cursos = cursoRepository.findAll(paginacao);
        return CursoResponse.converter(cursos);
    }

    public ResponseEntity<CursoResponse> salvar(CursoRequest cursoRequest, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRequest.converter();
        cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoResponse(curso));
    }

    public ResponseEntity<CursoResponse> atualizar(Long id, CursoRequest cursoRequest) {
        Curso curso = cursoRequest.atualizarEntidade(id, cursoRepository);
        return ResponseEntity.ok(new CursoResponse(curso));
    }

    public ResponseEntity<CursoResponse> pesquisarPorId(Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new CursoResponse(optional.get())) ;
        }
        return ResponseEntity.notFound().build();
    }

    public Page<CursoResponse> pesquisarPorCategoria(Pageable paginacao, String categoria) {
        Page<Curso> cursos = cursoRepository.findByCategoria(paginacao, categoria);
        return CursoResponse.converter(cursos);
    }

    public ResponseEntity<?> deletar(Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (optional.isPresent()) {
            cursoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
