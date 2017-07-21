package com.wacai.springboot_demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.wacai.springboot_demo.mapper.CourseMapper;
import com.wacai.springboot_demo.mapper.StudentCourseMapper;
import com.wacai.springboot_demo.mapper.StudentMapper;
import com.wacai.springboot_demo.model.CourseSelectInfo;
import com.wacai.springboot_demo.model.StudentCourse;
import com.wacai.springboot_demo.model.StudentCourseDetail;
import com.wacai.springboot_demo.service.CourseService;
import com.wacai.springboot_demo.service.StudentCourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprintbootDemoApplicationTests {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Autowired
    CourseService courseService;
    @Autowired
    StudentCourseService studentCourseService;

    @Test
    public void contextLoads() {
        //Integer studentId = 3;
        //Integer courseId = 2;
        //studentCourseService.save(courseId,studentId);
        //studentCourseService.delete(2);
        String url = "/";
        System.out.println(url.substring(0,url.indexOf('/')));
    }
}
