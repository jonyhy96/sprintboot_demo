package com.wacai.springboot_demo.service;

import java.util.List;

import com.wacai.springboot_demo.model.StudentCourseDetail;

/**
 * TODO 类描述
 *
 * @author pojun
 */
public interface StudentCourseService {

    /**
     * 根据学生id获取选课情况
     * @param studentId
     * @return
     * @throws RuntimeException
     */
    List<StudentCourseDetail> findStudentCoursesByStudentId(Integer studentId)
            throws RuntimeException;

    /**
     * 根据课程id获取选课情况
     * @param courseId
     * @return
     * @throws RuntimeException
     */
    List<StudentCourseDetail> findStudentCoursesByCourseId(Integer courseId)
            throws RuntimeException;

    /**
     * 选课
     * @return
     * @throws RuntimeException
     */
    boolean save(Integer courseId,Integer studentId) throws RuntimeException;

    /**
     * 退选
     * @throws RuntimeException
     */
    boolean delete(Integer studentCourseId) throws RuntimeException;

}
