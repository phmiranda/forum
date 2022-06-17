/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS USUÁRIOS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.domain.enums.UsuarioStatus;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private UsuarioStatus usuarioStatus;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.documento = usuario.getDocumento();
        this.usuarioStatus = usuario.getSituacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public UsuarioStatus getUsuarioStatus() {
        return usuarioStatus;
    }

    public static Page<UsuarioResponse> converter(Page<Usuario> usuarios) {
        return usuarios.map(UsuarioResponse::new);
    }
}
