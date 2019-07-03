package com.quartz.utils;

import com.quartz.util.MybatisPlusGeneratorUtils;
import org.junit.Test;

/**
 * Mybatis-Plus代码生成器工具类测试
 */
public class MybatisPlusGeneratorUtilsTest {

    /**
     * 测试代码生成
     */
    @Test
    public void generatorCodeTest () {
        MybatisPlusGeneratorUtils.generatorCode("quartz_info");
    }

}
