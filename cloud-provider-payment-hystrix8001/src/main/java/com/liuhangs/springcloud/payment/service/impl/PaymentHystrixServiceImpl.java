package com.liuhangs.springcloud.payment.service.impl;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.payment.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**这个类里包含服务降级和服务熔断的测试
 * @author 11757
 * @DATE 2020/7/15
 */
@Service
@Slf4j
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Value("${server.port}")
    private String SERVER_PORT;

    @Override
    public CommonResult getPaymentOK(Long id)
    {
        return new CommonResult(200, "请求ID为：" + id + "， 当前线程是：" + Thread.currentThread().getName() +
                "," +
                " " +
                "服务端口：" +
                SERVER_PORT);
    }

    /**
     * 超过3000毫秒或者报错就进入降级方法getPaymentTimeOutHandler
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPaymentTimeOutHandler", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000")})  //注解3秒后直接降级
    @Override
    public CommonResult getPaymentTimeOut(Long id)
    {
        //测试报错进入降级方法
        //int a = 1/0;
        //测试超时进入降级方法
        try
        {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return new CommonResult(200, "请求ID为：" + id + "， 当前线程是：" + Thread.currentThread().getName() + ", 服务端口：" +
                SERVER_PORT + ", 线程睡眠5秒");
    }

    /**
     * 服务降级后调用的方法
     * @param id
     * @return
     */
    public CommonResult getPaymentTimeOutHandler(Long id)
    {
        return new CommonResult(200, "请求ID为：" + id + "， 当前线程是：" + Thread.currentThread().getName() + ", 服务端口：" +
                SERVER_PORT + ", 已经进入降级方法");
    }


    /**
     * 服务熔断测试方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPaymentBreakFallbackMethod", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//检测最近10次请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //过多久再次检测是否关闭熔断器
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value = "60")//错误率为60%就开启熔断器
    })
    @Override
    public CommonResult getPaymentBreak(Long id)
    {
        if (id < 0) {
            try
            {
                //execution.isolation.thread.timeoutInMilliseconds默认是1秒，所以这里会超时
                TimeUnit.MILLISECONDS.sleep(5000);
            }
            catch (InterruptedException e)
            {
                log.error("执行getPaymentBreak方法超时，请稍后重试");
            }
        }
        return new CommonResult(200, "请求ID为：" + id + "， 当前线程是：" + Thread.currentThread().getName() + ", 服务端口：" +
                SERVER_PORT + ", 请求正确");
    }

    //熔断降级方法
    public CommonResult getPaymentBreakFallbackMethod(Long id)
    {
        return new CommonResult(200, "请求ID为：" + id + "， 当前线程是：" + Thread.currentThread().getName() + ", 服务端口：" +
                SERVER_PORT + ", 请求错误，进入降级熔断方法");
    }

    /**
     * 给80服务消费者准备的超时方法，避免和前面的服务降级方法混淆
     * 此方法会睡眠5秒
     * @param id
     * @return
     */
    @Override
    public CommonResult getPaymentTimeOutFor80(Long id)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return new CommonResult(200, "请求ID为：" + id + "， 当前线程是：" + Thread.currentThread().getName() + ", 服务端口：" +
                SERVER_PORT + ", 线程睡眠5秒");
    }
}
