/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU004
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE RESPOSTAS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mensagem;
    @ManyToOne
    private Topico topico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    private Usuario usuario;
    private Boolean solucao = false;
}
