package com.wacai.springboot_demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wacai.springboot_demo.model.CourseSelectInfo;
import com.wacai.springboot_demo.service.CourseService;
import com.wacai.springboot_demo.service.StudentCourseService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    CourseService courseService;
    @Autowired
    StudentCourseService studentCourseService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    String index(HttpSession session){
        Integer teacherId = (Integer) session.getAttribute("userId");
        return "redirect:/teacher/"+teacherId+"/course";
    }

    /**
     * 显示教师开课的选课情况
     * @return
     */
    @RequestMapping(value="/{teacherId}/course",method = RequestMethod.GET)
    String teacherCourses(@PathVariable("teacherId")Integer teacherId,
            Model model){
        //获取教师所开课的信息
        List<CourseSelectInfo> courses =
                courseService.findCourseWithTeacher(teacherId,null);
        model.addAttribute("courses",courses);
        return "teacher/index";
    }

}
