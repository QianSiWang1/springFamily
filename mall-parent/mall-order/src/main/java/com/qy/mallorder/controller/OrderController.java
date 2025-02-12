package com.qy.mallorder.controller;

import com.qy.mallorder.feign.CustomerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CustomerFeign customerFeign;

    @RequestMapping("/hello")
    public String hello() {
        return customerFeign.hello();
    }
}
