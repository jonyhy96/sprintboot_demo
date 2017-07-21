package com.wacai.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wacai.springboot_demo.mapper.TeacherMapper;
import com.wacai.springboot_demo.model.Teacher;
import com.wacai.springboot_demo.service.TeacherService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public boolean register(String name, String password) throws RuntimeException {
        Teacher teacher = new Teacher(name, password);
        return teacherMapper.save(teacher) > 0;
    }

    @Override
    public Teacher login(String name, String password) throws RuntimeException {
        Teacher teacher = teacherMapper.login(new Teacher(name, password));
        return teacher;
    }
}
