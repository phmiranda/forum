/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 21/06/2020
 */

package br.com.phmiranda.comunidade.exception;

import br.com.phmiranda.comunidade.config.FormRequestValidation;
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
public class ErrorValidationHandler {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormRequestValidation> handler(MethodArgumentNotValidException exception) {
        List<FormRequestValidation> formRequestValidations = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            FormRequestValidation errors = new FormRequestValidation(e.getField(),message);
            formRequestValidations.add(errors);
        });
        return formRequestValidations;
    }
}
