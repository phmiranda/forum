/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 28/06/2021
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.domain.dto.CursoDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDto> index() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converterCursoDtoParaEntidade(cursos);
    }

    public List<CursoDto> pesquisarCurso(Iterable<Long> id) {
        List<Curso> cursos = cursoRepository.findAllById(id);
        return CursoDto.converterCursoDtoParaEntidade(cursos);
    }
}
