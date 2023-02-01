package spring.crud.jdbc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring.crud.jdbc.model.dto.ExceptionDto;
import spring.crud.jdbc.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handle(NotFoundException ex) {
        log.error("NotFoundException ", ex);
        return new ExceptionDto(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handle(Exception ex) {
        log.error("Exception ", ex);
        return new ExceptionDto("UNEXPECTED_EXCEPTION");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        log.error("Validation exception: ", ex);
        List<ExceptionDto> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> errors.add(new ExceptionDto(e.getDefaultMessage())));
        return ResponseEntity.status(status).body(errors);
    }
}
