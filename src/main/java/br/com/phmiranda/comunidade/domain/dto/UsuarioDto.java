/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 28/06/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import br.com.phmiranda.comunidade.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDto {
    private Long id;
    private String nome;
    private String documento;
    private String email;

    // MÉTODO CONSTRUTOR
    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.documento = usuario.getDocumento();
        this.email = usuario.getEmail();
    }

    // CONVERSÃO DA ENTIDADE USUÁRIO
    public static List<UsuarioDto> converterUsuarioDtoParaEntidade(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}
