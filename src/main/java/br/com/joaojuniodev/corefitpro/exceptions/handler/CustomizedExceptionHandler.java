package br.com.joaojuniodev.corefitpro.exceptions.handler;

import br.com.joaojuniodev.corefitpro.exceptions.*;
import br.com.joaojuniodev.corefitpro.exceptions.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@RestControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
            ex.getMessage(),
            request.getDescription(true),
            new Date()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
            ex.getMessage(),
            request.getDescription(true),
            new Date()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IsEmptyObjectException.class)
    public final ResponseEntity<ExceptionResponse> handleIsEmptyObjectException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
            ex.getMessage(),
            request.getDescription(true),
            new Date()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectIsNullException.class)
    public final ResponseEntity<ExceptionResponse> handleObjectIsNullException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
            ex.getMessage(),
            request.getDescription(true),
            new Date()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileStorageException.class)
    public final ResponseEntity<ExceptionResponse> handleFileStorageException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
            ex.getMessage(),
            request.getDescription(true),
            new Date()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}