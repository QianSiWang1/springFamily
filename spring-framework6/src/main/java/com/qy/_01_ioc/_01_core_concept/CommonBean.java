package com.qy._01_ioc._01_core_concept;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2026/1/13
 */
@Component
@Data
public class CommonBean {
    private String name;

    private int num;
}
