package com.qy.mallorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "mall-customer-service",path = "/customer")
public interface CustomerFeign {

    @RequestMapping("/hello")
    String hello();
}
