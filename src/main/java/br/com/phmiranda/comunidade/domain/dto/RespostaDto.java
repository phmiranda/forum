/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 23/06/2020
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Resposta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RespostaDto {
    private Long id;
    private String autor;
    private String mensagem;
    private LocalDateTime dataCriacao;


    // Construtor padronizado.
    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.autor = resposta.getAutor().getNome();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
    }

    // CONVERSÃO DA ENTIDADE RESPOSTA
    public static List<RespostaDto> converterRespostaDtoParaEntidade(List<Resposta> respostas) {
        return respostas.stream().map(RespostaDto::new).collect(Collectors.toList());
    }
}
