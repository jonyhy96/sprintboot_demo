package com.wacai.springboot_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wacai.springboot_demo.enums.StateEnum;
import com.wacai.springboot_demo.mapper.CourseMapper;
import com.wacai.springboot_demo.mapper.StudentCourseMapper;
import com.wacai.springboot_demo.model.Course;
import com.wacai.springboot_demo.model.CourseSelectInfo;
import com.wacai.springboot_demo.model.StudentCourse;
import com.wacai.springboot_demo.service.CourseService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Override
    public List<CourseSelectInfo> findCourseWithTeacher(Integer teacherId,Integer studentId)
            throws RuntimeException {
        //获取基本信息
        List<CourseSelectInfo> courses = courseMapper.findCourseWithTeacher(teacherId);
        //判断是否可选
        if(studentId != null){
            for(CourseSelectInfo courseSelectInfo : courses){
                StudentCourse studentCourse = studentCourseMapper
                        .getByStudentIdAndCourseId(new StudentCourse(studentId,courseSelectInfo.getId()));
                courseSelectInfo.setSelected(false);
                courseSelectInfo.setSelectable(true);
                if(studentCourse != null &&
                        !studentCourse.getState().equals(StateEnum.DELETE.getState())){
                    courseSelectInfo.setSelected(true);
                    courseSelectInfo.setStudentCourseId(studentCourse.getId());
                }
                if(courseSelectInfo.getNumE() >= courseSelectInfo.getNum()){
                    courseSelectInfo.setSelectable(false);
                }
            }
        }
        return courses;
    }

    @Override
    public boolean deleteCourse(Integer courseId) throws RuntimeException {
        //修改对应课程选课状态
        studentCourseMapper.deleteByCourseId(courseId);
        //修改课程状态
        return courseMapper.deleteById(courseId) > 0;
    }

    @Override
    public boolean saveCourse(Course course) throws RuntimeException {
        return courseMapper.save(course) > 0;
    }
}
