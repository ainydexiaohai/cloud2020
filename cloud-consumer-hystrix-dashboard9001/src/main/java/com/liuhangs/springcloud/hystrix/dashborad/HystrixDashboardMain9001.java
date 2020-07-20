package com.liuhangs.springcloud.hystrix.dashborad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**监控工程启动类
 * @author 11757
 * @DATE 2020/7/16
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启dashboard，通过图形化的方式监控: 查看 http://127.0.0.1:9001/hystrix
public class HystrixDashboardMain9001 {

    public static void main(String[] args)
    {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
