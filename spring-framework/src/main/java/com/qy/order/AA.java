package com.qy.order;

import org.springframework.core.annotation.Order;

@Order(3)
public class AA {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
