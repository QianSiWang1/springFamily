package com.qy.service.impl.transaction;

import com.qy.mapper.UserMapper;
import com.qy.service.transcation.UserServiceB;
import com.qy.service.transcation.UserServiceC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceBImpl implements UserServiceB {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceC userServiceC;

    @Override
    public void updateUserNameB() {
        userMapper.updateUserNameById(12L,"TestB name1");
    }

    @Override
    @Async
    public void asyncWithoutTransactionNoException() {
        log.info("异步方法B 开始执行");
        userMapper.updateUserNameById(12L,"asyncWithoutTransactionNoException");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("异步方法B 执行完成");
    }

    @Override
    @Async
    public void asyncWithoutTransactionException() {
        log.info("异步方法B 开始执行");
        userMapper.updateUserNameById(12L,"asyncWithoutTransactionException");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("异步方法B 执行完成");
        int i = 1/0;
    }

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void asyncWithTransactionNoException() {
        userMapper.updateUserNameById(12L,"asyncWithTransactionNoException");
    }

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void asyncWithTransactionException() {
        userMapper.updateUserNameById(12L,"asyncWithTransactionException");
        int i = 1/0;
    }


    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void asyncInvokeMethodC() {
        userMapper.updateUserNameById(12L,"asyncInvokeMethodC");
        userServiceC.updateUser();
        int i = 1/0;
    }
}
