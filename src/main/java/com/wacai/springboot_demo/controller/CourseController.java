package com.wacai.springboot_demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wacai.springboot_demo.enums.base.ResultCode;
import com.wacai.springboot_demo.model.Course;
import com.wacai.springboot_demo.model.base.Result;
import com.wacai.springboot_demo.service.CourseService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value="", method = RequestMethod.GET)
    String saveCoursePage(){
        return "teacher/saveCourse";
    }

    /**
     * 老师开课
     * @return
     */
    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    Result saveCourse(Course course,HttpSession session){
        Result result = new Result();
        Integer teacherId = (Integer) session.getAttribute("userId");
        course.setTeacherId(teacherId);
        if(courseService.saveCourse(course)){
            result.setCode(ResultCode.SUCCESS);
        }else{
            result.setCode(ResultCode.FAIL);
            result.setMessage("开课失败");
        }
        return result;
    }

    /**
     * 删除课程
     * @return
     */
    @RequestMapping(value="{courseId}",method = RequestMethod.DELETE)
    @ResponseBody
    Result deleteCourse(@PathVariable("courseId")Integer courseId){
        Result result = new Result();
        if(courseService.deleteCourse(courseId)){
            result.setCode(ResultCode.SUCCESS);
        }else{
            result.setCode(ResultCode.FAIL);
            result.setMessage("删除失败");
        }
        return result;
    }

}
