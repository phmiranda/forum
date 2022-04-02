/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 29/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.DuvidaRequestDto;
import br.com.phmiranda.comunidade.domain.dto.request.UsuarioRequestDto;
import br.com.phmiranda.comunidade.domain.entity.Duvida;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaResponseDto;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import br.com.phmiranda.comunidade.repository.DuvidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class DuvidaService {

    @Autowired
    DuvidaRepository duvidaRepository;

    @Autowired
    CursoRepository cursoRepository;

    public List<DuvidaResponseDto> index() {
        List<Duvida> duvidas = duvidaRepository.findAll();
        return DuvidaResponseDto.converter(duvidas);
    }

    public ResponseEntity<DuvidaResponseDto> salvar(DuvidaRequestDto duvidaRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        Duvida duvida = duvidaRequestDto.converter(cursoRepository);
        duvidaRepository.save(duvida);
        URI uri = uriComponentsBuilder.path("/duvidas/{id}").buildAndExpand(duvida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DuvidaResponseDto(duvida));
    }

    public void pesquisarPorId() {

    }

    public List<DuvidaResponseDto> pesquisarPorTitulo(String titulo) {
        List<Duvida> duvidas = duvidaRepository.findByTitulo(titulo);
        return DuvidaResponseDto.converter(duvidas);
    }

    public List<DuvidaResponseDto> pesquisarPorCursoVinculado(String curso) {
        List<Duvida> duvidas = duvidaRepository.findByCursoNome(curso);
        return DuvidaResponseDto.converter(duvidas);
    }
}
