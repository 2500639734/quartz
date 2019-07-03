package com.quartz.enumeration;

public enum ProjectVariableEnum {

    PROJECT_ABSOLUTE_PATH_KEY ("user_dir");

    ProjectVariableEnum (String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }

}
