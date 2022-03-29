/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.entity.Curso;
import br.com.phmiranda.comunidade.domain.dto.response.CursoResponseDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {


    @Autowired
    CursoRepository cursoRepository;

    public List<CursoResponseDto> index() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoResponseDto.converter(cursos);
    }

    public List<CursoResponseDto> pesquisarPorId(Long id) {
        //List<Curso> cursos = cursoRepository.findById(id);
        //return CursoResponseDto.converter(cursos);
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
