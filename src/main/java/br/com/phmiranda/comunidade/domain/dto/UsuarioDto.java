/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String nome;
    private String documento;
    private String email;
}
