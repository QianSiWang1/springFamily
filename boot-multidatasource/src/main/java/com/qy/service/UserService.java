package com.qy.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.qy.entity.DataSourceUser;
import com.qy.mapper.DataSourceUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    DataSourceUserMapper userMapper;

    @DS("db1")
    public List<DataSourceUser> getList() {
        return userMapper.getList();
    }

    @DS("db2")
    public List<DataSourceUser> getListFromDb2() {
        return userMapper.getList();
    }
}
