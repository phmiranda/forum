/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU003
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE TÓPICOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TopicoDto {
    private Long id;
    private String titulo;
    private String descricaoDuvida;
    private LocalDateTime dataCriacao;
}
