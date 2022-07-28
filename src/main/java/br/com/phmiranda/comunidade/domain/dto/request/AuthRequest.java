/**
 * User: Pedro
 * Project: comunidade
 * User History: nº 999
 * Description: N/A
 * Date: 28/07/2022
 */

package br.com.phmiranda.comunidade.domain.dto.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthRequest {
    /*@NotBlank
    @NotEmpty
    @NotNull*/
    private String email;

    /*@NotBlank
    @NotEmpty
    @NotNull*/
    private String senha;

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

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
