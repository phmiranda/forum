/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.domain.dto.request;

import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.domain.enums.UsuarioStatus;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioUpdateRequest {
    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String usuarioStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuarioStatus() {
        return usuarioStatus;
    }

    public void setUsuarioStatus(String usuarioStatus) {
        this.usuarioStatus = usuarioStatus;
    }

    public Usuario atualizarEntidade(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setSituacao(UsuarioStatus.valueOf(this.usuarioStatus));
        return usuario;
    }
}
