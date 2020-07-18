package com.liuhangs.springcloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 11757
 * @DATE 2020/7/13
 */
@Slf4j
public class MyRibbonLoadBalancedRule extends AbstractLoadBalancerRule {

    /**
     * 调用次数
     */
    private AtomicInteger transferCount;

    public MyRibbonLoadBalancedRule() {
        transferCount = new AtomicInteger(0);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    public Server choose(ILoadBalancer lb, Object key)
    {
        log.info("进入我自己的负载均衡规则类");
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }

        int count = 0;
        Server server = null;
        while (server == null && count <= 10)
        {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            if (CollectionUtils.isEmpty(reachableServers) || CollectionUtils.isEmpty(allServers))
            {
                continue;
            }

            //得到选择服务器的下标
            int chooseServerSubscript = getChooseServerSubscript(reachableServers.size());

            server = reachableServers.get(chooseServerSubscript);
            if(null == server) {
                continue;
            }
            return server;
        }

        if(count > 10) {
            log.warn("循环10次也没有找到可用的服务");
        }
        return null;
    }

    /**
     * 得到选择服务器的下标
     * @param size 可到达的服务器总数
     * @return
     */
    private int getChooseServerSubscript(int size) {
        int current = 0;
        int subscript = 0;
        //自旋锁保证线程安全
        do
        {
            //得到当前的调用次数
            current = this.transferCount.get();
            //得到调用服务器的下标
            subscript = (current + 1) % size;
        } while (!this.transferCount.compareAndSet(current, subscript));
        return subscript;
    }
}
