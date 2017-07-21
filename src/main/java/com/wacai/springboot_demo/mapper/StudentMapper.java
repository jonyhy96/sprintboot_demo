package com.wacai.springboot_demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wacai.springboot_demo.model.Student;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Mapper
public interface StudentMapper {

    int save(Student student);

    Student login(Student student);

}
