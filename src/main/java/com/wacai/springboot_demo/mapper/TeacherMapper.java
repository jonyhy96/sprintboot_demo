package com.wacai.springboot_demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wacai.springboot_demo.model.Teacher;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Mapper
public interface TeacherMapper {

    int save(Teacher teacher);

    Teacher login(Teacher teacher);
}
