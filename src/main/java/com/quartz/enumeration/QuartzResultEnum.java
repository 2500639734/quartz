package com.quartz.enumeration;


public enum QuartzResultEnum {

    SUCCESS (1, "成功"),
    FAILURE (2, "失败");

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
