package com.wacai.springboot_demo.enums;

/**
 * 用户类型枚举
 *
 * @author pojun
 */
public enum UserTypeEnum {
    STUDENT((short)1,"学生"),
    TEACHER((short)0,"教师")
    ;

    private Short type;
    private String info;

    UserTypeEnum(Short type, String info) {
        this.type = type;
        this.info = info;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
