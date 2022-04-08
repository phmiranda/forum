/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Duvida;
import br.com.phmiranda.comunidade.domain.enums.DuvidaStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DuvidaDetalheResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String nomeCurso;
    private String nomeUsuario;
    private DuvidaStatus duvidaStatus;
    private LocalDateTime dataCriacao;
    private List<RespostaResponse> respostas;

    public DuvidaDetalheResponse(Duvida duvida) {
        this.id = duvida.getId();
        this.titulo = duvida.getTitulo();
        this.descricao = duvida.getDescricao();
        this.nomeCurso = duvida.getCurso().getNome();
        this.nomeUsuario = duvida.getUsuario().getNome();
        this.duvidaStatus = duvida.getDuvidaStatus();
        this.dataCriacao = duvida.getDataCriacao();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(duvida.getRespostas().stream().map(RespostaResponse::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public DuvidaStatus getDuvidaStatus() {
        return duvidaStatus;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public List<RespostaResponse> getRespostas() {
        return respostas;
    }
}
