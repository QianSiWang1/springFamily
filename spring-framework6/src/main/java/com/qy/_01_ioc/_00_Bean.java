package com.qy._01_ioc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2025/12/11
 */
@Component
public class _00_Bean implements InitializingBean {

    private final _00_InnerBean innerBean;

    @Autowired
    public _00_Bean(_00_InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_01_Bean innerBean : " + innerBean);
    }
}
