package com.liuhangs.springcloud.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//name：建议写服务名称     configuration：配置类
//http://springCloud-ribbon-police/getPolice 调用"springCloud-ribbon-police"这个服务ID的时候，将会启用下面的配置
@Configuration
public class LbConfig {

    @Bean
    public IRule getRule(){
        return new MyRibbonLoadBalancedRule();
    }
    
}