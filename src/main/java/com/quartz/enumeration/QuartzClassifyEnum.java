package com.quartz.enumeration;

public enum QuartzClassifyEnum {

    QuartzJobClassify(),
    QuartzJobGroupClassify();

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}
