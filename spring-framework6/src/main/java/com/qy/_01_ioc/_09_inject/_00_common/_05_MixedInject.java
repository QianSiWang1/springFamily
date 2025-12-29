package com.qy._01_ioc._09_inject._00_common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2025/12/11
 */
@Component
public class _05_MixedInject implements InitializingBean {
    private final _00_InnerBean innerBean;


    @Autowired
    private _00_InnerBeanTwo innerBeanTwo;

    @Autowired
    public _05_MixedInject(_00_InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_05_MixedInject ===> _00_InnerBean innerBean : " + innerBean);
        System.out.println("_05_MixedInject ===> _00_InnerBeanTwo innerBean : " + innerBeanTwo);
    }
}
