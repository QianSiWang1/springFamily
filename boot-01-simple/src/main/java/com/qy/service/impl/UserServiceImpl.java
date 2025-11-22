package com.qy.service.impl;

import com.qy.mapper.UserMapper;
import com.qy.service.UserService;
import com.qy.vo.UserListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public List<UserListVo> getUserList(){
        List<Object> data = userMapper.getUserList();
        List<UserListVo> userListVos = (List<UserListVo>) data.get(0);
        int total = ((List<Integer>)data.get(1)).get(0);
        log.info("total is {}",total);
        log.info("userVoList is {}",userListVos);
        return userListVos;
    }
}
