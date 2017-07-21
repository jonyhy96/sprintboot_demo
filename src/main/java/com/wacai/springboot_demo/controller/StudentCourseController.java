package com.wacai.springboot_demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wacai.springboot_demo.enums.base.ResultCode;
import com.wacai.springboot_demo.model.StudentCourseDetail;
import com.wacai.springboot_demo.model.base.Result;
import com.wacai.springboot_demo.service.StudentCourseService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Controller
@RequestMapping("/studentCourse")
public class StudentCourseController {

    @Autowired
    StudentCourseService studentCourseService;

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    Result saveStudentCourse(@RequestParam(name="courseId")Integer courseId,HttpSession session){
        Result res = new Result();
        Integer studentId = (Integer) session.getAttribute("userId");
        if(studentCourseService.save(courseId,studentId)){
            res.setCode(ResultCode.SUCCESS);
        }else{
            res.setCode(ResultCode.FAIL);
            res.setMessage("选课失败");
        }
        return res;
    }

    @RequestMapping(value="/{studentCourseId}",method = RequestMethod.DELETE)
    @ResponseBody
    Result deleteStudentCourse(@PathVariable("studentCourseId")Integer studentCourseId){
        Result res = new Result();
        if(studentCourseService.delete(studentCourseId)){
            res.setCode(ResultCode.SUCCESS);
        }else{
            res.setCode(ResultCode.FAIL);
            res.setMessage("退选失败");
        }
        return res;
    }

    /**
     * 获取某课程的选课情况
     * @return
     */
    @RequestMapping(value ="/{courseId}",method = RequestMethod.GET)
    String findStudentCoursesOfCourse(@PathVariable("courseId")Integer courseId,
            Model model){
        List<StudentCourseDetail> studentCourses
                = studentCourseService.findStudentCoursesByCourseId(courseId);
        model.addAttribute("studentCourses",studentCourses);
        return "teacher/studentCourse";
    }

}
