/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS RESPOSTAS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Resposta;

import java.util.List;
import java.util.stream.Collectors;

public class RespostaResponseDto {
    private Long id;
    private String descricao;

    public RespostaResponseDto(Resposta resposta) {
        this.id = resposta.getId();
        this.descricao = resposta.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static List<RespostaResponseDto> converter(List<Resposta> respostas) {
        return respostas.stream().map(RespostaResponseDto::new).collect(Collectors.toList());
    }
}
