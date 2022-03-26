/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-3
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO E GERENCIAMENTO DE RESPOSTAS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @Column(name = "id", nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_criacao", nullable = false, length = 100)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Duvida duvida;

    @Column(name = "situacao", nullable = false, length = 100)
    private Boolean situacao = Boolean.FALSE;
}
