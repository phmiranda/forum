/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 21/06/2020
 */

package br.com.phmiranda.comunidade.exception.handler;

import br.com.phmiranda.comunidade.exception.validation.FormValidationDto;
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
public class ErrorHandlerException {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormValidationDto> handle(MethodArgumentNotValidException exception) {
        List<FormValidationDto> validations = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            FormValidationDto errors = new FormValidationDto(error.getField(),message);
            validations.add(errors);
        });
        return validations;
    }
}
