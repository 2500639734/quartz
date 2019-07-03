package com.quartz.enumeration;

public enum QuartzClassifyEnum {

    QuartzJobClassify("quartz_job", "quartz_job_group"),
    QuartzJobGroupClassify("", "");

    QuartzClassifyEnum (String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    private String name;

    private String groupName;

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

}
