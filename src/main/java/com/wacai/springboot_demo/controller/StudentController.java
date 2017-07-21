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
import com.wacai.springboot_demo.model.StudentCourseDetail;
import com.wacai.springboot_demo.service.CourseService;
import com.wacai.springboot_demo.service.StudentCourseService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CourseService courseService;
    @Autowired
    StudentCourseService studentCourseService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    String index(HttpSession session){
        Integer studentId = (Integer) session.getAttribute("userId");
        return "redirect:/student/"+studentId+"/course";
    }

    /**
     *显示某学生可选课程、已选课程
     * @return
     */
    @RequestMapping(value="/{studentId}/course",method = RequestMethod.GET)
    String findCourses(@PathVariable("studentId")Integer studentId,
            Model model){
        //获取可选课程
        List<CourseSelectInfo> selectableCourses =
                courseService.findCourseWithTeacher(null,studentId);
        model.addAttribute("selectableCourses",selectableCourses);
        //获取已选课程
        List<StudentCourseDetail> selectedCourses =
                studentCourseService.findStudentCoursesByStudentId(studentId);
        model.addAttribute("selectedCourses",selectedCourses);
        return "student/index";
    }

}
