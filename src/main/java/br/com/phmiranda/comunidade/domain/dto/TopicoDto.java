/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU3 - CADASTRO DO RECURSO DE TÓPICOS
 * Description: CONSTRUÇÃO DO ENDPOINT REFERENTE AO RECURSO DE TÓPICOS
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Topico;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    // MÉTODO CONSTRUTOR.
    public TopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    // CONVERSÃO DA ENTIDADE TÓPICO
    public static Page<TopicoDto> converterTopicoDtoParaEntidade(Page<Topico> topicos) {
        return topicos.map(TopicoDto::new);
    }
}
