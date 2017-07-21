package com.wacai.springboot_demo.service;

import com.wacai.springboot_demo.model.Teacher;

/**
 * TODO 类描述
 *
 * @author pojun
 */
public interface TeacherService {

    /**
     * 老师注册
     *
     * @throws RuntimeException
     */
    boolean register(String name, String password)
            throws RuntimeException;

    /**
     * 老师登录
     *
     * @throws RuntimeException
     */
    Teacher login(String name, String password) throws RuntimeException;
}
