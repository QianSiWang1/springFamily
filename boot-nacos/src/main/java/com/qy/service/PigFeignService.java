package com.qy.service;


//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "nacos-pig-service",path = "/pig")
public interface PigFeignService {
    @GetMapping("/hello")
    public String hello();
}
