package com.example.movie;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("MICROSERVICE-PROVIDER-USER")
public interface UserClient {
    // PathVariable不支持正则，必须设置value 不会默认是参数变量名 不支持GetMapping、PostMapping等
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    User getUser(@PathVariable("id") Long id);
}
