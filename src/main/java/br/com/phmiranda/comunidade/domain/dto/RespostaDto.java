/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Resposta;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RespostaDto {
    private Long id;
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.usuario = resposta.getUsuario().getNome();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public static List<RespostaDto> converter(List<Resposta> respostas) {
        return respostas.stream().map(RespostaDto::new).collect(Collectors.toList());
    }
}
