/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-XXX
 * Description: CONSTRUÇÃO DA CLASSE DE TRANSFERÊNCIA DE OBJETOS DO SERVIÇO DE CADASTRO DOS TÓPICOS.
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto.response;

import java.time.LocalDateTime;

public class DuvidaResponseDto {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
}
