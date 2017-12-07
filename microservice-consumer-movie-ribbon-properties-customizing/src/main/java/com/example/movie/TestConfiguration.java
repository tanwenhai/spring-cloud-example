package com.example.movie;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeComponentScan
public class TestConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
