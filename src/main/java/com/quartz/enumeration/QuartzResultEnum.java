package com.quartz.enumeration;


public enum QuartzResultEnum {

    EXECUTE_SUCCESS (10, "success"),
    EXECUTE_FAILURE (20, "failure");

    QuartzResultEnum (Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
