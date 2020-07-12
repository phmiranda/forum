/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 22/06/2020
 */

package br.com.alura.comunidade.config;

public class FormRequestValidation {
    private String attribute;
    private String error;

    public FormRequestValidation(String attribute, String error) {
        this.attribute = attribute;
        this.error = error;
    }

    // Getters e Setters
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
