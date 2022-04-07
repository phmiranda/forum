/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS CURSOS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoResponseDto {
    private Long id;
    private String nome;
    private String categoria;

    public CursoResponseDto(Curso curso) {
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

    public static List<CursoResponseDto> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoResponseDto::new).collect(Collectors.toList());
    }
}
