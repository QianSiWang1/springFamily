package com.qy._01_ioc._01_core_concept;

import org.springframework.core.Ordered;

/**
 * @Author qy
 * @Date 2026/1/17
 */
public class _06_OrderedB implements Ordered {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
