package com.qy.mybatis;

import com.qy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class mybatisTest {
    @Autowired
    UserService userService;

    @Test
    public void test1(){
        userService.getUserList();
    }
}
