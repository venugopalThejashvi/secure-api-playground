package com.care.predict.exception;

import com.care.predict.exception.custom.UserAlreadyPresentException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpStatusCode> handleException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**DATABASE EXCEPTION*/
    @ExceptionHandler(CannotCreateTransactionException.class)
    public ResponseEntity<HttpStatusCode> handleException(CannotCreateTransactionException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<HttpStatusCode> handleException(NoResourceFoundException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpStatusCode> handleException(Exception ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<HttpStatusCode> handleException(ResponseStatusException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<HttpStatusCode> handleException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /** INVALID CREDENTIALS */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpStatusCode> handleException(BadCredentialsException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyPresentException.class)
    public ResponseEntity<HttpStatusCode> handleException(UserAlreadyPresentException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpStatusCode> handleException(MethodArgumentNotValidException ex, HttpServletRequest request){
        printExceptionLog(ex,request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /** USED TO PRINT LOG's WHILE THERE IS A EXCEPTION */
    public static void printExceptionLog(Exception ex, String uri){
        log.error("{} : {} : {}", ex.getClass().getSimpleName(), ex, uri);
    }
    
}
