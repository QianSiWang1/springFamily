package com.qy.mybatis;

import com.qy.entity.User;
import com.qy.mapper.UserMapper;
import com.qy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class mybatisTest {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        userService.getUserList();
    }

    @Test
    public void test2(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users.toString());
    }
}
