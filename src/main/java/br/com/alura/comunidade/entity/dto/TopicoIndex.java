/**
 * User: phmiranda
 * Project: forum
 * Date: 05/05/2020
 */

package br.com.alura.comunidade.entity.dto;

import br.com.alura.comunidade.entity.model.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoIndex {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    // comentário.
    public TopicoIndex(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoIndex> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoIndex::new).collect(Collectors.toList());
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
