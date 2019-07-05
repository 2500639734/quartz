package com.quartz.mapper;

import com.quartz.QuartzApplicationTests;
import com.quartz.enumeration.EffectivenessEnum;
import com.quartz.pojo.QuartzInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartzInfoMapperTest extends QuartzApplicationTests {

    @Autowired
    private QuartzInfoMapper quartzInfoMapper;

    @Test
    public void insertTest () {
        QuartzInfo quartzInfo = new QuartzInfo()
                .setName("test").setCycle("0 */5 * * * ?").setClassPath("com.quartz.test.TestQuartz")
                .setStatus(EffectivenessEnum.VALID.getType()).setDescription("test insert quartz_info");
        quartzInfoMapper.insert(quartzInfo);
    }

    @Test
    public void deleteTest () {
        quartzInfoMapper.deleteById(1L);
    }

    @Test
    public void updateTest () {
        QuartzInfo quartzInfo = new QuartzInfo()
                .setId(1L)
                .setClassPath("com.test").setDescription("test update quartz_info");
        quartzInfoMapper.updateById(quartzInfo);
    }

    @Test
    public void selectTest () {
        QuartzInfo quartzInfo = quartzInfoMapper.selectById(1L);
        System.out.println(quartzInfo);
    }

}
