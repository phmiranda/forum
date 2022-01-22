/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: SRC-3
 * Description: ALURA - SPRING BOOT API REST: CONSTRUA UMA API
 * Date: 20/07/2022
 */

package br.com.phmiranda.comunidade.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
public class Usuario  {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 250)
    private String nome;

    @Column(name = "numero_documento", nullable = false, length = 11)
    private String numeroDocumento;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "senha", nullable = false, length = 250)
    private String senha;
}
