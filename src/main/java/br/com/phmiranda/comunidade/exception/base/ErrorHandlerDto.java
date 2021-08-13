/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 05/08/2021
 */
package br.com.phmiranda.comunidade.exception.base;

public class ErrorHandlerDto {
    private String key;
    private String value;

    public ErrorHandlerDto(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
