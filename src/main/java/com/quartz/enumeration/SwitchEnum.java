package com.quartz.enumeration;

public enum SwitchEnum {

    ON (true, "开启"),
    OFF(false, "关闭"),
    START (true, "启动"),
    UNSTART (true, "不启动");

    SwitchEnum(Boolean status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private Boolean status;

    private String desc;

    public Boolean getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
