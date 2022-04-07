/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 07/04/2022
 */

package br.com.phmiranda.comunidade.config.exception;

import br.com.phmiranda.comunidade.domain.dto.handler.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionController {
    @Autowired
    // classe responsável por capturar informações de idioma/local.
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Exception> handle(MethodArgumentNotValidException exception) {

        // cria um array com os atributos da classe de exceção DTO.
        List<Exception> exceptions = new ArrayList<>();

        // captura quais os campos que estão com problemas e lançará na exceção.
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        // percorre a lista de erros para cada campo e a mensagem, além de atribuir um idioma do sistema.
        errors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            Exception error = new Exception(e.getField(), "Erro no atributo " + e.getField() + ", o atributo pode com problemas relacionado a " + mensagem);
            exceptions.add(error);
        });

        // retornar as exceções capturadas no formulário.
        return exceptions;
    }
}
