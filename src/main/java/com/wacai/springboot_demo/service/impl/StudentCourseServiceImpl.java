package com.wacai.springboot_demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wacai.springboot_demo.enums.StateEnum;
import com.wacai.springboot_demo.mapper.CourseMapper;
import com.wacai.springboot_demo.mapper.StudentCourseMapper;
import com.wacai.springboot_demo.model.CourseSelectInfo;
import com.wacai.springboot_demo.model.StudentCourse;
import com.wacai.springboot_demo.model.StudentCourseDetail;
import com.wacai.springboot_demo.service.StudentCourseService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Service
@Transactional
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<StudentCourseDetail> findStudentCoursesByStudentId(Integer studentId)
            throws RuntimeException {
        return studentCourseMapper.find(new StudentCourse(studentId,null));
    }

    @Override
    public List<StudentCourseDetail> findStudentCoursesByCourseId(Integer courseId)
            throws RuntimeException {
        return studentCourseMapper.find(new StudentCourse(null,courseId));
    }

    @Override
    public boolean save(Integer courseId, Integer studentId) throws RuntimeException {
        //如果课程容量已满，选课失败
        CourseSelectInfo courseSelectInfo = courseMapper.getCourseWithNumEById(courseId);
        if(courseSelectInfo.getNumE() >= courseSelectInfo.getNum()){
            return false;
        }
        //判断是否选择过，选过恢复，否则新建
        StudentCourse studentCourse = new StudentCourse(studentId,courseId);
        StudentCourse pre =  studentCourseMapper.getByStudentIdAndCourseId(studentCourse);
        if(pre == null){
            studentCourse.setCreateTime(new Date());
            return studentCourseMapper.save(studentCourse) > 0;
        }else{
            return !pre.getState().equals(StateEnum.DELETE)
                    && studentCourseMapper.recover(pre.getId()) > 0;
        }

    }

    @Override
    public boolean delete(Integer studentCourseId) throws RuntimeException {
        return studentCourseMapper.deleteById(studentCourseId) > 0;
    }
}
