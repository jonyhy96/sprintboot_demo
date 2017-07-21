package com.wacai.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wacai.springboot_demo.mapper.StudentMapper;
import com.wacai.springboot_demo.model.Student;
import com.wacai.springboot_demo.service.StudentService;

/**
 * TODO 类描述
 *
 * @author pojun
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean register(String name, String password) throws RuntimeException {
        Student student = new Student(name, password);
        return studentMapper.save(student) > 0;
    }

    @Override
    public Student login(String name, String password) throws RuntimeException {
        Student student = studentMapper.login(new Student(name, password));
        return student;
    }
}
