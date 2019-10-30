package com.tenpen.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = "com.tenpen.base")
@MapperScan("com.tenpen.base.dao")
public class TenpenApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TenpenApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TenpenApiApplication.class, args);
    }

}
