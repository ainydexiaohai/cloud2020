package com.liuhangs.springcloud.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign日志开启
 * OpenFeign的日志级别有：
 NONE： 默认的，不显示任何日志
 BASIC： 仅记录请求方法、URL、响应状态码以及执行时间
 HEADERS：除了BASIC 中自定义的信息外，还有请求和响应的信息头
 FULL： 除了HEADERS中定义的信息外， 还有请求和响应的正文以及元数据。
 */
@Configuration
public class OpenFeignLogConfig {

    @Bean
    Logger.Level feignLoggerLeave(){
        return Logger.Level.FULL;
    }
}