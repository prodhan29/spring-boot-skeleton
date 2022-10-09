package com.nahid.simpleboot.exception;

import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nahid.simpleboot.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ErrorResponse unauthorized(HttpClientErrorException.Unauthorized unauthorizedException) {
//        logger.error(unauthorizedException.getMessage());
        return new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), unauthorizedException.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ErrorResponse nullPointer(NullPointerException nullPointerException) {
//        logger.error(nullPointerException.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), nullPointerException.getMessage());
    }

}
