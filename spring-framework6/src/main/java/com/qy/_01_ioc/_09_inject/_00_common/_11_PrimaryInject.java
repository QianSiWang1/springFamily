package com.qy._01_ioc._09_inject._00_common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2025/12/13
 */
@Component
public class _11_PrimaryInject implements InitializingBean {
    @Autowired
    private _00_InnerBean innerBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_11_PrimaryInject ===> _00_InnerBean innerBean : " + innerBean.getName());
    }
}
