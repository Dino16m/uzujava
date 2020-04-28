package com.uzu.utils.auth.exceptions.handlers;

import com.uzu.utils.auth.exceptions.helpers.JsonErrorBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestAccessDeniedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDenied(Exception e, WebRequest request)
    {
        String body = JsonErrorBuilder.makeJson();
        return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }


}
