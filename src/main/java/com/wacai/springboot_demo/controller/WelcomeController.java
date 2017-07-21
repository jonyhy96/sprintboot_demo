package com.wacai.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wacai.springboot_demo.model.base.Result;

/**
 * @author pojun
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    String index() {
        return "redirect:/user/login";
    }

    @RequestMapping("/ex")
    String error(){
        throw new RuntimeException("出错");
    }
    @RequestMapping("/json")
    @ResponseBody
    Result errorJson(){
        throw new RuntimeException("Rest接口出错");
    }
}

