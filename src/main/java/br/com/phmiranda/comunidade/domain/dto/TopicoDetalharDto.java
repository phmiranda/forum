/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 05/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Topico;
import br.com.phmiranda.comunidade.domain.enums.TopicoStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDetalharDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private String usuario;
    private TopicoStatus status;
    private LocalDateTime dataCriacao;
    private List<RespostaDto> respostas;

    public TopicoDetalharDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.usuario = topico.getUsuario().getNome();
        this.status = topico.getTopicoStatus();
        this.dataCriacao = topico.getDataCriacao();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getUsuario() {
        return usuario;
    }

    public TopicoStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public List<RespostaDto> getRespostas() {
        return respostas;
    }
}
