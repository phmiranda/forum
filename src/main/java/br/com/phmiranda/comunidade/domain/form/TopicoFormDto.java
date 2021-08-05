/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.form;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.domain.Topico;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicoFormDto {

    @NotNull
    @NotEmpty
    @Length(min = 1)
    private String titulo;

    @NotNull
    @NotEmpty
    @Length(min = 1)
    private String mensagem;

    @NotNull
    @NotEmpty
    @Length(min = 1)
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
