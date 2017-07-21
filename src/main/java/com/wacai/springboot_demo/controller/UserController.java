package com.wacai.springboot_demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wacai.springboot_demo.enums.UserTypeEnum;
import com.wacai.springboot_demo.enums.base.ResultCode;
import com.wacai.springboot_demo.model.Student;
import com.wacai.springboot_demo.model.Teacher;
import com.wacai.springboot_demo.model.base.Result;
import com.wacai.springboot_demo.service.StudentService;
import com.wacai.springboot_demo.service.TeacherService;

/**
 * 教师、学生共用
 *
 * @author pojun
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    /**
     * 登录页
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String userLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    Result userLogin(@RequestParam(name = "userType") Short userType,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password,
            HttpSession session) {
        Result res = new Result();
        res.setCode(ResultCode.SUCCESS);
        if (UserTypeEnum.STUDENT.getType().equals(userType)) {
            Student student = studentService.login(name, password);
            if (student == null) {
                res.setMessage("用户名或密码错误");
                res.setCode(ResultCode.FAIL);
            } else {
                session.setAttribute("userId", student.getId());
                session.setAttribute("userName", student.getName());
                res.setData(student.getId());
            }
        } else {
            Teacher teacher = teacherService.login(name, password);
            if (teacher == null) {
                res.setCode(ResultCode.FAIL);
                res.setMessage("用户名或密码错误");
            } else {
                session.setAttribute("userId", teacher.getId());
                session.setAttribute("userName", teacher.getName());
                res.setData(teacher.getId());
            }
        }
        return res;
    }

    /**
     * 注册页
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    String userRegisterPage() {
        return "register";
    }

    /**
     * 用户注册
     *
     * @param userType 用户类型 @see UserTypeEnum
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    String userRegister(@RequestParam(name = "userType") Short userType,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password) {
        if (UserTypeEnum.STUDENT.getType().equals(userType)) {
            studentService.register(name, password);
        } else {
            teacherService.register(name, password);
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    String logout(HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        return "redirect:/user/login";
    }
}
