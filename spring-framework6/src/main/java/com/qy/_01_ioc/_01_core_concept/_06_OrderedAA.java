package com.qy._01_ioc._01_core_concept;

import org.springframework.core.annotation.Order;

/**
 * @Author qy
 * @Date 2026/1/17
 */
@Order(3)
public class _06_OrderedAA {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
