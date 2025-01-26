package com.qy.beanlife;

import org.springframework.stereotype.Component;

@Component
public class MyAutoCloseable implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Auto Closeable 销毁方法");
    }
}
