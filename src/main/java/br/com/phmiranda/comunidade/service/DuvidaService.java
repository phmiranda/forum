/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 29/03/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.DuvidaUpdateRequest;
import br.com.phmiranda.comunidade.domain.dto.request.DuvidaRequest;
import br.com.phmiranda.comunidade.domain.dto.response.DuvidaDetalharResponse;
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
import java.util.Optional;

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

    public ResponseEntity<DuvidaResponse> atualizar(Long id, DuvidaUpdateRequest duvidaUpdateRequest) {
        Duvida duvida = duvidaUpdateRequest.atualizarEntidade(id, duvidaRepository);
        return ResponseEntity.ok(new DuvidaResponse(duvida));
    }

    public DuvidaDetalharResponse pesquisarPorId(Long id) {
        Duvida duvida = duvidaRepository.getOne(id);
        return new DuvidaDetalharResponse(duvida);
    }

    public ResponseEntity<?> deletar(Long id) {
        Optional<Duvida> optional = duvidaRepository.findById(id);
        if (optional.isPresent()) {
            duvidaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
