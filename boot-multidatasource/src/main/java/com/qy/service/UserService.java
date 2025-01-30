package com.qy.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.qy.entity.User;
import com.qy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @DS("db1")
    public List<User> getList() {
        return userMapper.getList();
    }

    @DS("db2")
    public List<User> getListFromDb2() {
        return userMapper.getList();
    }
}
