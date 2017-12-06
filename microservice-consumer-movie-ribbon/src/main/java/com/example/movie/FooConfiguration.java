package com.example.movie;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 默认都使用轮询
 * MICROSERVICE-SIMPLE-PROVIDER-USER 使用TestConfiguration中的负载算法
 */
@Configuration
@RibbonClient(name = "MICROSERVICE-SIMPLE-PROVIDER-USER", configuration = TestConfiguration.class)
public class FooConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}