package com.liuhangs.springcloud.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

/**
 * @author 11757
 * @DATE 2020/7/15
 */
@SpringBootApplication
@EnableCircuitBreaker  //使用Hystrix需要开启熔断注解
public class PaymentHystrixStart8001 {

    public static void main(String[] args)
    {
        SpringApplication.run(PaymentHystrixStart8001.class, args);
    }

    /**
     * 给Hystrix Dashboard指定当前工程的监控路径为：http://127.0.0.1:8001/hystrix.stream
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
