package com.qy.order;

import org.springframework.core.annotation.Order;

@Order(2)
public class BB{

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}