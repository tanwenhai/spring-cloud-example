package com.example.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeComponentScan.class)
    }
)
public class MicroserviceSimpleConsumerMovieRibbonApplication {

    // 使用ribbon客户端负载均衡
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
	    return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerMovieRibbonApplication.class, args);
	}
}
