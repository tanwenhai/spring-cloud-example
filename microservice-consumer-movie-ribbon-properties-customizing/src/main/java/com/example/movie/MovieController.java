package com.example.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");

        System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/" + id, User.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");

        System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return "1";
    }

    @GetMapping("/test2")
    public String test2() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER2");
        System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return "1";
    }
}
