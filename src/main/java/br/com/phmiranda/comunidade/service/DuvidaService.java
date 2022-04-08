/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 29/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.DuvidaRequest;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaDetalheResponse;
import br.com.phmiranda.comunidade.domain.entity.Duvida;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaResponse;
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

    public List<DuvidaResponse> index() {
        List<Duvida> duvidas = duvidaRepository.findAll();
        return DuvidaResponse.converter(duvidas);
    }

    public ResponseEntity<DuvidaResponse> salvar(DuvidaRequest duvidaRequest, UriComponentsBuilder uriComponentsBuilder) {
        Duvida duvida = duvidaRequest.converter(cursoRepository);
        duvidaRepository.save(duvida);
        URI uri = uriComponentsBuilder.path("/duvidas/{id}").buildAndExpand(duvida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DuvidaResponse(duvida));
    }

    public DuvidaDetalheResponse pesquisarPorId(Long id) {
        Duvida duvida = duvidaRepository.getOne(id);
        return new DuvidaDetalheResponse(duvida);
    }
}
