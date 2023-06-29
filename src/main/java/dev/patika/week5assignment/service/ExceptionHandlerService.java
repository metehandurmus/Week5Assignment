package dev.patika.week5assignment.service;

import dev.patika.week5assignment.decoder.FeignErrorDecoder;
import dev.patika.week5assignment.exception.ExpeditionException;
import dev.patika.week5assignment.exception.TicketException;
import dev.patika.week5assignment.responseDto.FeignExceptionResponseDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerService {
    private final FeignErrorDecoder feignErrorDecoder;

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException missingServletRequestParameterException) {
        return new ResponseEntity<>(missingServletRequestParameterException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("Bu ID değerine sahip bir kayıt bulunamadı.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpeditionException.class)
    public ResponseEntity<String> expeditionExceptionHandler(ExpeditionException expeditionException) {
        return new ResponseEntity<>(expeditionException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errorList = new HashMap<>();

        for (FieldError fieldError :
                methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketException.class)
    public ResponseEntity<String> ticketExceptionHandler(TicketException ticketException) {
        return new ResponseEntity<>(ticketException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FeignExceptionResponseDto feignExceptionHandler(FeignException feignException) {
        return feignErrorDecoder.feignExceptionResponseDto(feignException.contentUTF8());
    }
}
