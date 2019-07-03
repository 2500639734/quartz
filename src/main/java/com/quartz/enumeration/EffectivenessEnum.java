package com.quartz.enumeration;

public enum EffectivenessEnum {

    VALID(true, "有效"),
    INVALID(false, "无效");

    EffectivenessEnum(Boolean valid, String desc) {
        this.valid = valid;
        this.desc = desc;
    }

    private Boolean valid;

    private String desc;

    public Boolean getValid() {
        return valid;
    }

    public String getDesc() {
        return desc;
    }
}
