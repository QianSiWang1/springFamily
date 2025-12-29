package com.qy._01_ioc._09_inject._00_common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2025/12/11
 */
@Component
public class _02_ConstructorInject implements InitializingBean {
    private final _00_InnerBean innerBean;


    public _02_ConstructorInject(_00_InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_02_ConstructorInject ===> _00_InnerBean innerBean : " + innerBean);
    }
}
