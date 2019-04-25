package com.mybatis.generator.enumUtil;

public enum MyExceptionEnum {
    LOGIN(1, "Is_Not_Login", "301"),
    SUCCESS(2, "Login_Is_Success", "200" ),
    FIAL(3, "用户名或密码不对", "302"),
    UNkNOWN(4, "未知系统异常", "500"),
    ALREADY_EXIST(5, "用户名已存在", "302"),
    USER_NAME_DOS_NOT_EXIST(6, "用户名不存在,请重新输入！", "303"),
    PASSWORD_DOS_NOT_EXIST(7, "密码有误,请重新输入！", "304");

    private int index;
    private String message;
    private String code;

    MyExceptionEnum(int index, String message, String code) {
        this.index = index;
        this.message = message;
        this.code = code;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MyExceptionEnum{" +
                "index=" + index +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
