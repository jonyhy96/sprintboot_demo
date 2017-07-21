package com.wacai.springboot_demo.service;

import java.util.List;

import com.wacai.springboot_demo.model.Course;
import com.wacai.springboot_demo.model.CourseSelectInfo;

/**
 * TODO 类描述
 *
 * @author pojun
 */
public interface CourseService {

    /**
     *获取课程信息
     * @param teacherId   不为空获取该教师所开课
     * @param studentId   不为空信息追加该学生选课情况
     * @return
     * @throws RuntimeException
     */
    List<CourseSelectInfo> findCourseWithTeacher(Integer teacherId,Integer studentId)
            throws RuntimeException;

    /**
     * 删除课程
     * @return
     * @throws RuntimeException
     */
    boolean deleteCourse(Integer courseId) throws RuntimeException;

    boolean saveCourse(Course course) throws RuntimeException;

}
