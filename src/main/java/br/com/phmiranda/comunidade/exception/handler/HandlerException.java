/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 04/08/2021
 */

package br.com.phmiranda.comunidade.exception.handler;

import br.com.phmiranda.comunidade.exception.base.ErrorHandlerDto;
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
public class HandlerException {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorHandlerDto> handler(MethodArgumentNotValidException exception) {
        List<ErrorHandlerDto> handler = new ArrayList<>();
        List<FieldError> fields = exception.getBindingResult().getFieldErrors();
        fields.forEach(e -> {
            String messagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorHandlerDto error = new ErrorHandlerDto(e.getField(), messagem);
            handler.add(error);
        });
        return handler;
    }
}
