/*
 * Author: phmiranda
 * Project: comunidade
 * User Story: SGD-8
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE CURSOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cursos")
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
