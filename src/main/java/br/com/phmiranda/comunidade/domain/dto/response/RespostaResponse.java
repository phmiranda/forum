/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS RESPOSTAS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Resposta;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RespostaResponse {
    private Long id;
    private String descricao;
    private LocalDateTime dataCriacao;
    private String usuario;
    private String duvida;

    public RespostaResponse(Resposta resposta) {
        this.id = resposta.getId();
        this.descricao = resposta.getDescricao();
        this.dataCriacao = resposta.getDataCriacao();
        this.usuario = resposta.getUsuario().getNome();
        this.duvida = resposta.getDuvida().getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDuvida() {
        return duvida;
    }

    public static Page<RespostaResponse> converter(Page<Resposta> respostas) {
        return respostas.map(RespostaResponse::new);
    }
}
