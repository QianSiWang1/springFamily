package com.qy.beanlife;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * 销毁方法
 */
@Component
public class MyDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("我被销毁了");
    }
}
