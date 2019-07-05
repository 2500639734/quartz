package com.quartz.manage;

import com.quartz.base.BaseQuartz;
import com.quartz.enumeration.QuartzResultEnum;

public class HelloQuartz extends BaseQuartz {

    @Override
    public QuartzResultEnum job() {
        System.out.println("====================>>>>>  working");
        return QuartzResultEnum.SUCCESS;
    }

}
