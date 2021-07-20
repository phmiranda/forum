/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU003
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE TÓPICOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import br.com.phmiranda.comunidade.domain.enums.TopicoStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Topico {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private TopicoStatus status = TopicoStatus.NAO_RESPONDIDO;
    private Usuario usuario;
    private Curso curso;
    private List<Resposta> respostas = new ArrayList<>();
}
