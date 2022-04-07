/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 74
 * Description: Trabalhando com POST
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.domain.dto.request;

import br.com.phmiranda.comunidade.domain.entity.Curso;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursoRequest {
    @NotNull
    @NotEmpty
    @Length(min = 1, max = 100)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 50)
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
