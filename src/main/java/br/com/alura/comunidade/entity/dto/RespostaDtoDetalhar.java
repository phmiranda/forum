/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 23/06/2020
 */

package br.com.alura.comunidade.entity.dto;

import br.com.alura.comunidade.entity.model.Resposta;

import java.time.LocalDateTime;

public class RespostaDtoDetalhar {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    // Construtor padronizado.
    public RespostaDtoDetalhar(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
