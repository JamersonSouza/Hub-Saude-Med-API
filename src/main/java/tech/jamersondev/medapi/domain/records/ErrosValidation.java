package tech.jamersondev.medapi.domain.records;

import org.springframework.validation.FieldError;

public record ErrosValidation(String field, String message) {

    public ErrosValidation (FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
