package com.example.movie;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "MICROSERVICE-PROVIDER-USER", configuration = Configuration1.class)
public interface UserClient {
    @RequestLine("GET /{id}")
    User getUser(@Param("id") Long id);
}
