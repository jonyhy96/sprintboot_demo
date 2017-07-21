package com.wacai.springboot_demo.enums;

/**
 * TODO 类描述
 *
 * @author pojun
 */
public enum StateEnum {
    DELETE((short)-1,"已删除"),
    AVAILABLE((short)1,"可用");
    private Short state;
    private String info;

    StateEnum(Short state, String info) {
        this.state = state;
        this.info = info;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
