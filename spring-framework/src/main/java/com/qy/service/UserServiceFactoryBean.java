package com.qy.service;

import org.springframework.beans.factory.FactoryBean;

public class UserServiceFactoryBean implements FactoryBean<UserService> {
    @Override
    public UserService getObject() throws Exception {
        UserService userService = new UserService();

        return userService;
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }
}
