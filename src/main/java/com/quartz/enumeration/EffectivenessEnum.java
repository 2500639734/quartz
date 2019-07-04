package com.quartz.enumeration;

public enum EffectivenessEnum {

    VALID(true, "有效"),
    INVALID(false, "无效");

    EffectivenessEnum(Boolean type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Boolean type;

    private String desc;

    public Boolean getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
