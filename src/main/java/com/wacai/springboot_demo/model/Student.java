package com.wacai.springboot_demo.model;

/**
 * TODO 类描述
 *
 * @author pojun
 */
public class Student {
    private Integer id;
    private String name;
    private String password;
    private Short state;

    public Student() {
    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}
