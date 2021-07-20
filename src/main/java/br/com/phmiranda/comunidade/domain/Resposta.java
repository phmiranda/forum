/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU004
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE RESPOSTAS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import java.time.LocalDateTime;

public class Resposta {
    private Long id;
    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private Usuario autor;
    private Boolean solucao = false;
}
