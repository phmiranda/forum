/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 74
 * Description: Trabalhando com POST
 * Date: 28/03/2022
 */

package br.com.phmiranda.comunidade.domain.dto.request;

import br.com.phmiranda.comunidade.domain.entity.Duvida;
import br.com.phmiranda.comunidade.domain.entity.Resposta;
import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.repository.DuvidaRepository;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RespostaRequest {
    @NotNull
    @NotEmpty
    private String descricao;

    @NotNull
    @NotEmpty
    private String nomeUsuario;

    @NotNull
    @NotEmpty
    private String duvidaTitulo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDuvidaTitulo() {
        return duvidaTitulo;
    }

    public void setDuvidaTitulo(String duvidaTitulo) {
        this.duvidaTitulo = duvidaTitulo;
    }

    public Resposta converter(UsuarioRepository usuarioRepository, DuvidaRepository duvidaRepository) {
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
        Duvida duvida = duvidaRepository.findByTitulo(duvidaTitulo);
        return new Resposta(descricao, usuario, duvida);
    }
}
