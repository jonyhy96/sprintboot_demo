package com.wacai.springboot_demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wacai.springboot_demo.model.Course;
import com.wacai.springboot_demo.model.CourseSelectInfo;

/**
 * @author pojun
 */
@Mapper
public interface CourseMapper {

    /**
     * 添加课程
     */
    int save(Course course);


    Course getById(Integer courseId);

    /**
     *获取某课程信息及已选人数
     */
    CourseSelectInfo getCourseWithNumEById(Integer courseId);

    /**
     * 根据教师id获取课程信息，id为null时获取所有课程信息（包括选课人数）
     * @return
     */
    List<CourseSelectInfo> findCourseWithTeacher(Integer teacherId);

    int deleteById(Integer id);



}
