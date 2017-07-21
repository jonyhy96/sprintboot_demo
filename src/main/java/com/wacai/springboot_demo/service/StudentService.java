package com.wacai.springboot_demo.service;

import com.wacai.springboot_demo.model.Student;

/**
 *
 * @author pojun
 */
public interface StudentService {

    /**
     * 学生注册
     *
     * @throws RuntimeException
     */
    boolean register(String name, String password)
            throws RuntimeException;

    /**
     * 学生登录，登录失败返回null
     *
     * @throws RuntimeException
     */
    Student login(String name, String password)
            throws RuntimeException;
}
