package com.quartz.manage;

import com.quartz.base.BaseQuartz;
import com.quartz.enumeration.QuartzResultEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloQuartz extends BaseQuartz {

    @Override
    public QuartzResultEnum job() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String nowTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(String.format("%s ====================>>>>>  working", nowTime));
        return QuartzResultEnum.SUCCESS;
    }

}
