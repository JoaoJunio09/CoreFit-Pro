package br.com.joaojuniodev.corefitpro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsEmptyObjectException extends RuntimeException {
    public IsEmptyObjectException(String message) {
        super(message);
    }
}