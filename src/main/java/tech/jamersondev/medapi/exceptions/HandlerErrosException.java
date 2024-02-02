package tech.jamersondev.medapi.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.jamersondev.medapi.domain.records.ErrosValidation;

import java.util.List;

@ControllerAdvice
public class HandlerErrosException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerErrorNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerErrorMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(fieldErrors.stream().map(ErrosValidation::new).toList());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handlerErrorValidationException(ValidationException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
