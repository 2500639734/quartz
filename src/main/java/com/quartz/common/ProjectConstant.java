package com.quartz.common;

import com.quartz.enumeration.ProjectVariableEnum;

public class ProjectConstant {

    private ProjectConstant () {

    }

    private static final String PROJECT_ABSOLUTE_PATH = System.getProperty(ProjectVariableEnum.PROJECT_ABSOLUTE_PATH_KEY.getKey());

}
