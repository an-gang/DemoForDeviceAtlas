package com.gangan.demofordeviceatlas.framework.exception;

import com.gangan.demofordeviceatlas.framework.AjaxResult;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        return AjaxResult.error(405, e.getMethod() + " Method is not support for request URL " + request.getRequestURI());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public AjaxResult handleDuplicateKeyException() {
        return AjaxResult.error(409, "Duplicate entry");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public AjaxResult handleDataIntegrityViolationException(Exception e) {
        return AjaxResult.error(403, "Unable to operate a occupied record");
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) {
        e.printStackTrace();
        return AjaxResult.error("server error, please try again later");
    }

}
