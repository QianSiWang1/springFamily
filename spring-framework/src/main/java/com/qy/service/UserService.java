package com.qy.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("qianyu")
    private User user;
    public void sayHello() {
        System.out.println("hello");
    }

    public void test() {
        System.out.println(user);
    }
}
