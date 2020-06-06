/**
 * User: phmiranda
 * Project: forum
 * Date: 05/05/2020
 */

package br.com.alura.comunidade.entity.dto;

import br.com.alura.comunidade.entity.model.Curso;
import br.com.alura.comunidade.entity.model.Topico;
import br.com.alura.comunidade.repository.CursoRepository;

public class TopicoForm {
    private String titulo;
    private String mensagem;
    private String nomeCurso;

    // comentário
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
