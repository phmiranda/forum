/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.domain.dto.request;


import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.repository.RespostaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RespostaUpdateRequest {
    @NotNull
    @NotEmpty
    @Length(min = 1)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Resposta atualizarEntidade(Long id, RespostaRepository respostaRepository) {
        Resposta resposta = respostaRepository.getOne(id);
        resposta.setDescricao(this.descricao);
        return resposta;
    }
}
