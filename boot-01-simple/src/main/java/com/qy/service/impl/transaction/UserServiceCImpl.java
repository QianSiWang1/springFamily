package com.qy.service.impl.transaction;

import com.qy.mapper.UserMapper;
import com.qy.service.transcation.UserServiceC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceCImpl implements UserServiceC {
    @Autowired
    UserMapper userMapper;

    @Override
    public void updateUser() {
        userMapper.updateUserNameById(13L,"C updateUser");
    }
}
