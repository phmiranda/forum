/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS USUÁRIOS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import br.com.phmiranda.comunidade.domain.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String email;
    private String documento;

    public UsuarioResponseDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.documento = usuario.getDocumento();
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

    public static List<UsuarioResponseDto> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioResponseDto::new).collect(Collectors.toList());
    }
}
