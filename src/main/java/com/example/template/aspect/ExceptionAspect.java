package com.example.template.aspect;

import com.example.template.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理切面
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAspect {
    private final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    /**
     * 400 bad request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        logger.error("could not read json...", e);
        return new Response().failure("could not read json");
    }

    /**
     * 400 bad request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response handleValidationException(
            MethodArgumentNotValidException e) {
        logger.error("could not read json...", e);
        return new Response().failure("parameter validation exception");
    }

    /**
     * 405 ServeltException 子类
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        logger.error("request method not supported...", e);
        return new Response().failure("request method not supported");
    }

    /**
     * 415 unSupported Media type, ServeltException 子类
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response handleHttpMediaTypeNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        logger.error("content type not supported...", e);
        return new Response().failure("request method not supported");
    }


    /**
     * 500 Internal server error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        logger.error("Internal server error", e);
        return new Response().failure("internal server error");
    }
}
