/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.domain.dto.request;

import br.com.phmiranda.comunidade.domain.entity.Duvida;
import br.com.phmiranda.comunidade.domain.enums.DuvidaStatus;
import br.com.phmiranda.comunidade.repository.DuvidaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DuvidaUpdateRequest {
    @NotNull
    @NotEmpty
    @Length(min = 1, max = 100)
    private String titulo;

    @NotNull
    @NotEmpty
    private String descricao;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 25)
    private String duvidaStatus;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuvidaStatus() {
        return duvidaStatus;
    }

    public void setDuvidaStatus(String duvidaStatus) {
        this.duvidaStatus = duvidaStatus;
    }

    public Duvida atualizarEntidade(Long id, DuvidaRepository duvidaRepository) {
        Duvida duvida = duvidaRepository.getOne(id);
        duvida.setTitulo(this.titulo);
        duvida.setDescricao(this.descricao);
        duvida.setDuvidaStatus(DuvidaStatus.valueOf(this.duvidaStatus));
        return duvida;
    }
}
