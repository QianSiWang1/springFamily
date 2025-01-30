package com.qy.controller;

import com.qy.entity.User;
import com.qy.mapper.UserMapper;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/list")
    public List<User> getUsers(){
        return userService.getList();
    }

    @GetMapping("/user/list2")
    public List<User> getUsers2(){
        return userService.getListFromDb2();
    }
}
