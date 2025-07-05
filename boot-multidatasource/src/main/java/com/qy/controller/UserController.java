package com.qy.controller;

import com.qy.entity.DataSourceUser;
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
    public List<DataSourceUser> getUsers(){
        return userService.getList();
    }

    @GetMapping("/user/list2")
    public List<DataSourceUser> getUsers2(){
        return userService.getListFromDb2();
    }
}
