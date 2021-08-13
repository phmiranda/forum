/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 05/08/2021
 */

package br.com.phmiranda.comunidade.domain.form;

import br.com.phmiranda.comunidade.domain.Curso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursoFormDto {
    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Curso converter() {
        return new Curso(nome, categoria);
    }
}
