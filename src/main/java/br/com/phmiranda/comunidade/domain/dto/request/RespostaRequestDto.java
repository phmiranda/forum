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

public class RespostaRequestDto {
    private String descricao;
    private String nomeUsuario;
    private String tituloDuvida;

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

    public String getTituloDuvida() {
        return tituloDuvida;
    }

    public void setTituloDuvida(String tituloDuvida) {
        this.tituloDuvida = tituloDuvida;
    }

    public Resposta converter(UsuarioRepository usuarioRepository, DuvidaRepository duvidaRepository) {
        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
        Duvida duvida = duvidaRepository.findByTituloDuvida(tituloDuvida);
        return new Resposta(descricao, usuario, duvida);
    }
}
