/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 05/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Curso;

public class CursoDetalharDto {
    private Long id;
    private String nome;
    private String categoria;

    public CursoDetalharDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
}
