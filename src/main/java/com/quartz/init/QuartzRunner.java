package com.quartz.init;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quartz.enumeration.SwitchEnum;
import com.quartz.manage.QuartzManage;
import com.quartz.pojo.QuartzInfo;
import com.quartz.service.QuartzInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class QuartzRunner implements ApplicationRunner {

    @Autowired
    private QuartzInfoService quartzInfoService;

    @Override
    public void run(ApplicationArguments args) {
        List<QuartzInfo> quartzInfoList = quartzInfoService.list(new QueryWrapper<QuartzInfo>().eq("status", SwitchEnum.ON.getStatus()));
        QuartzManage.init(quartzInfoList, SwitchEnum.START.getStatus());
    }

}
