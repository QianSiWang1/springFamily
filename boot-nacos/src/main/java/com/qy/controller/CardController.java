package com.qy.controller;

import com.qy.service.PigFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@RequestMapping("/card")
public class CardController {


    private String userName;

//    @Autowired
//    private PigFeignService pigFeignService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Card Service" + userName;
    }


//    @GetMapping("/pig")
//    public String pigHello() {
//        return pigFeignService.hello();
//    }
}
