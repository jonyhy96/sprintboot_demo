package com.wacai.springboot_demo.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wacai.springboot_demo.enums.base.ResultCode;
import com.wacai.springboot_demo.model.base.Result;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@RestControllerAdvice
public class RestExpectionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception {
        e.printStackTrace();
        Result result = new Result();
        result.setCode(ResultCode.INTERNAL_SERVER_ERROR);
        result.setMessage("服务器内部错误");
        return result;
    }
}
