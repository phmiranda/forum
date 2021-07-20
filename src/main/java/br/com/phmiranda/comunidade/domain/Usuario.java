/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU001
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE USUÁRIOS.
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private Long id;
    private String email;
    private String senha;
}
