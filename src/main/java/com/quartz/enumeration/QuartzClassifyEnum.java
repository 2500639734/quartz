package com.quartz.enumeration;

public enum QuartzClassifyEnum {

    JOB_GROUP_NAME("quartz_job_group", "定时任务组名"),
    TRIGGER_GROUP_NAME("quartz_trigger_group", "触发器组名");

    QuartzClassifyEnum (String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
