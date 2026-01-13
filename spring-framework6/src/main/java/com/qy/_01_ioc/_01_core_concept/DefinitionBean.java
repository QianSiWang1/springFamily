package com.qy._01_ioc._01_core_concept;

import lombok.Data;

@Data
public class DefinitionBean {
    private String name;

    public void init()
    {
        System.out.println("hello");
    }
}
