package com.qy.service.impl.transaction;

import com.qy.mapper.UserMapper;
import com.qy.service.transcation.UserServiceA;
import com.qy.service.transcation.UserServiceB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceAImpl implements UserServiceA {
    private static final Logger log = LoggerFactory.getLogger(UserServiceAImpl.class);
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceB userServiceB;

    @Autowired
    ApplicationContext applicationContext;


    @Override
    public void updateUserNameAWithOutTransaction() {
        userMapper.updateUserNameById(11L,"Test1 Name");
        int i = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserNameAWithTransaction() {
        userMapper.updateUserNameById(11L,"Test2 Name");
        int i = 1/0;
    }

    @Override
    public void updateUserNameBinAWithOutTransaction() {
        userMapper.updateUserNameById(11L,"Test1 Name");
        userServiceB.updateUserNameB();
        int i = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserNameBinAWithTransaction() {
        userMapper.updateUserNameById(11L,"TestA Name");
        userServiceB.updateUserNameB();
        int i = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncBAndAException() {
        userMapper.updateUserNameById(11L,"asyncBAndAException");
        userServiceB.asyncWithoutTransactionNoException();
        log.info("异步方法后台执行");
        int i = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncBExceptionAndAException() {
        userMapper.updateUserNameById(11L,"asyncBAndAException");
        userServiceB.asyncWithoutTransactionException();
        log.info("异步方法后台执行");
        int i = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncBTransactionExceptionAndA() {
        userMapper.updateUserNameById(11L,"asyncBTransactionExceptionAndA");
        userServiceB.asyncWithTransactionException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncBTransactionAndAException() {
        userMapper.updateUserNameById(11L,"asyncBTransactionAndAException");
        userServiceB.asyncWithTransactionNoException();
        log.info("异步方法后台执行");
        int i = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncBTransactionExceptionAndAException() {
        userMapper.updateUserNameById(11L,"asyncBTransactionAndAException");
        userServiceB.asyncWithTransactionException();
        log.info("异步方法后台执行");
        int i = 1/0;
    }

    @Override
    public void asyncBAndBInvokeMethodC() {
        userServiceB.asyncInvokeMethodC();
    }
}
