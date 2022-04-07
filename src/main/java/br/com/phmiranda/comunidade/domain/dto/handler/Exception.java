/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.domain.dto.handler;

public class Exception {
    private String atributo;
    private String mensagem;

    public Exception(String atributo, String mensagem) {
        this.atributo = atributo;
        this.mensagem = mensagem;
    }

    public String getAtributo() {
        return atributo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
