package com.liuhangs.springcloud.payment.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import com.liuhangs.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**服务提供者controller
 * @author 11757
 * @DATE 2020/7/10
 */
@RequestMapping("provider/payment")
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    public CommonResult save(@RequestBody Payment payment)
    {
        int result = paymentService.save(payment);
        if(result == 1) {
            return new CommonResult(200, "调用端口" + SERVER_PORT + "保存支付流水成功");
        }
        return new CommonResult(444, "调用端口" + SERVER_PORT + "保存支付流水失败");
    }

    @GetMapping("{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.queryPaymentById(id);
        if(payment != null) {
            return new CommonResult<Payment>(200, "调用端口" + SERVER_PORT + "查询支付流水成功", payment);
        }
        return new CommonResult<Payment>(444, "调用端口" + SERVER_PORT + "查询支付流水失败");
    }

    /**
     * 服务发现测试
     * @return
     */
    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        //得到eureka上注册的所有服务，包括payment和order
        for(String service : services) {
            log.info("eureka上注册服务：{}", service);
        }

        //得到CLOUD-PROVIDER-PAYMENT服务上的所有实例，就是PAYMENT下的所有微服务集群。
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for(ServiceInstance instance : instances) {
            log.info("CLOUD-PROVIDER-PAYMENT服务的服务ID：{}，主机：{}，端口：{}，URI：{}", instance
                    .getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri());
        }
        return discoveryClient;
    }

    /**
     * 故意暂停3秒
     * @param id
     * @return
     */
    @GetMapping("/timeout/{id}")
    public CommonResult testTimeout(@PathVariable("id") Long id)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return new CommonResult(200, "调用端口" + SERVER_PORT + "查询支付流水成功，暂停3秒，Id = " + id);
    }
}
