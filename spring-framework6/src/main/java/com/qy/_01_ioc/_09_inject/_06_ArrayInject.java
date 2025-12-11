package com.qy._01_ioc._09_inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author qy
 * @Date 2025/12/11
 */
@Component
public class _06_ArrayInject implements InitializingBean {
    @Autowired
    _00_InnerBean[] innerBeans;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_06_ArrayInject ===> _00_InnerBean innerBean : " + Arrays.toString(innerBeans));
    }
}
