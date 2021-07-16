/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU06 - BACKEND
 * Description: DESENVOLVIMENTO DO FLUXO DE AUTENTICAÇÃO DA API.
 * Date: 01/07/2021
 */

package br.com.phmiranda.comunidade.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {
    private String token;
    private String type;

    public TokenDto(String token, String type) {
        this.token = token;
        this.type = type;
    }
}
