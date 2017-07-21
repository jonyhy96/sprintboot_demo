package com.wacai.springboot_demo.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@ControllerAdvice
public class ExpectionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception {
        e.printStackTrace();
        return DEFAULT_ERROR_VIEW;
    }
}
