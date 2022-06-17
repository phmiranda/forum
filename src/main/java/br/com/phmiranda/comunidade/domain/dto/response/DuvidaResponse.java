/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS TÓPICOS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Duvida;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DuvidaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;

    public DuvidaResponse(Duvida duvida) {
        this.id = duvida.getId();
        this.titulo = duvida.getTitulo();
        this.descricao = duvida.getDescricao();
        this.dataCriacao = duvida.getDataCriacao();
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public static Page<DuvidaResponse> converter(Page<Duvida> duvidas) {
        return duvidas.map(DuvidaResponse::new);
    }
}
