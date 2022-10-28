package com.cybertek.exception;

import com.cybertek.entity.ResponseWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice   // this annotation means that, if you want to use this class you don't need to create an object for it
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionMessageHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ResponseWrapper> serviceException(ServiceException se) {

        String message = se.getMessage();

        return new ResponseEntity<>(ResponseWrapper.builder().success(false).code(HttpStatus.CONFLICT.value()).message(message).build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseWrapper> accessDeniedException(ServiceException se) {
        String message = se.getMessage();

        return new ResponseEntity<>(ResponseWrapper.builder().success(false).code(HttpStatus.FORBIDDEN.value()).message(message).build(), HttpStatus.FORBIDDEN);

    }

}
