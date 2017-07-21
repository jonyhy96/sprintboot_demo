package com.wacai.springboot_demo.model;

/**
 * 学生选课、教师查看选课情况用model
 *
 * @author pojun
 */
public class CourseSelectInfo {

    private Integer id;
    private String name;
    private Integer num;
    private Teacher teacher;
    //已选人数
    private Integer numE;
    //是否已选
    private Boolean selected;
    private Integer studentCourseId;
    //是否可选
    private Boolean selectable;

    public CourseSelectInfo() {
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getNumE() {
        return numE;
    }

    public void setNumE(Integer numE) {
        this.numE = numE;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Integer getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(Integer studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }
}
