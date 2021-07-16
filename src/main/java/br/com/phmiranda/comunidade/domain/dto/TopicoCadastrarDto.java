/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU3 - CADASTRO DO RECURSO DE TÓPICOS
 * Description: CONSTRUÇÃO DO ENDPOINT REFERENTE AO RECURSO DE TÓPICOS
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Curso;
import br.com.phmiranda.comunidade.domain.Topico;
import br.com.phmiranda.comunidade.domain.Usuario;
import br.com.phmiranda.comunidade.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicoCadastrarDto {
    @NotNull
    @NotEmpty
    @Length(min = 5, max = 50)
    private String titulo;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String mensagem;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 30)
    private String nomeDoCurso;

    public TopicoCadastrarDto(String titulo, String mensagem, String nomeDoCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeDoCurso = nomeDoCurso;
    }

    public Topico converterTopicoDtoParaEntidade(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(titulo);
        return new Topico(titulo, mensagem, curso);
    }
}
