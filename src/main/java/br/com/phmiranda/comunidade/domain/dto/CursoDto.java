/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 28/06/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Curso;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CursoDto {
    private Long id;
    private String nome;
    private String categoria;

    // CONSTRUTOR QUE RECEBE UMA ENTIDADE CURSO PARA SETAR INFORMAÇÕES
    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }

    // CONVERSÃO DA ENTIDADE CURSO
    public static List<CursoDto> converterCursoDtoParaEntidade(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }
}
