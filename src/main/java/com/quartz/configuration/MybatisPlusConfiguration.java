package com.quartz.configuration;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis-Plus配置类
 * 配置Mapper接口的扫描路径,以及分页插件
 */
@Configuration
//@MapperScan("com.houpu.zy.module.*.mapper*")//这个注解，作用相当于下面的@Bean MapperScannerConfigurer，2者配置1份即可
public class MybatisPlusConfiguration {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * mybatis-plus逻辑分页插件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 相当于顶部的:
     * {@code @MapperScan("com.houpu.springboot.module.*.mapper*")}
     * 这里可以扩展,比如使用配置文件来配置扫描Mapper的路径
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.quartz.mapper*");
        return scannerConfigurer;
    }

}