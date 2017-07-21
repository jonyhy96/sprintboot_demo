package com.wacai.springboot_demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wacai.springboot_demo.model.StudentCourse;
import com.wacai.springboot_demo.model.StudentCourseDetail;

/**
 *
 * @author pojun
 */
@Mapper
public interface StudentCourseMapper {

    /**
     * 根据学生id，课程id获取选课
     * @param studentCourse
     * @return
     */
    StudentCourse getByStudentIdAndCourseId(StudentCourse studentCourse);

    int save(StudentCourse studentCourse);

    /**
     * 按照学生id或者课程id获取选课详情
     * @return
     */
    List<StudentCourseDetail> find(StudentCourse studentCourse);

    int deleteById(Integer id);

    /**
     * 原先退选的记录恢复
     * @return
     */
    int recover(Integer studentCourseId);

    /**
     *删除某课程的选课记录
     * @return
     */
    int deleteByCourseId(Integer courseId);
}
