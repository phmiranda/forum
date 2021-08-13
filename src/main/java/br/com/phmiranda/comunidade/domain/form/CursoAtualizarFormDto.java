/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 05/08/2021
 */
package br.com.phmiranda.comunidade.domain.form;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursoAtualizarFormDto {
    @NotNull
    @NotEmpty
    @Length(min = 1)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 1)
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

    public Curso atualizarRecurso(Long id, CursoRepository cursoRepository) {
        Curso curso = cursoRepository.getOne(id);
        curso.setNome(this.nome);
        curso.setCategoria(this.categoria);
        return curso;
    }
}
