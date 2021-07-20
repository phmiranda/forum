/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU06 - AUTENTICAÇÃO DA API.
 * Description: DESENVOLVIMENTO DO FLUXO DE AUTENTICAÇÃO DA API.
 * Date: 30/06/2021
 */

package br.com.phmiranda.comunidade.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "perfis")
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPerfil implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nome", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Override
    public String getAuthority() {
        return nome;
    }
}
