package com.umbrella.core.common.result_manage;

public enum ResultEnum {

    SUCCESS(000,"成功"),
    ERROR(001,"失败"),
    NULL(002,"结果空");


    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
