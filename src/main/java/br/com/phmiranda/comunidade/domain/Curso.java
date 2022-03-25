/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-3
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO E GERENCIAMENTO DE CURSOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;
}
