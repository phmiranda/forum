/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.request.RespostaRequestDto;
import br.com.phmiranda.comunidade.domain.dto.response.RespostaResponseDto;
import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    RespostaService respostaService;

    @GetMapping
    public List<RespostaResponseDto> index() {
        return respostaService.index();
    }

    @PostMapping
    public ResponseEntity<RespostaResponseDto> cadastrar(RespostaRequestDto respostaRequestDto, UriComponentsBuilder uriComponentsBuilder) {
        return respostaService.salvar(respostaRequestDto, uriComponentsBuilder);
    }

    @GetMapping("/filtro/{id}")
    public List<RespostaResponseDto> pesquisarPorId(Long id) {
        return respostaService.pesquisarPorId(id);
    }

    @GetMapping("/filtro/duvida")
    public List<RespostaResponseDto> pesquisarPorDuvida(String duvida) {
        return respostaService.pesquisarPorDuvida(duvida);
    }

    @GetMapping("/filtro/usuario")
    public List<RespostaResponseDto> pesquisarPorUsuario(String usuario) {
        return respostaService.pesquisarPorUsuario(usuario);
    }

    @GetMapping("/filtro/situacao")
    public List<RespostaResponseDto> pesquisarPorSituacao(String situacao) {
        return respostaService.pesquisarPorSituacao(situacao);
    }
}
