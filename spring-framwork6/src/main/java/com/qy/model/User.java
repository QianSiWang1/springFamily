package com.qy.model;

import lombok.Data;

@Data
public class User {
    private String name;

    private int age;

    public void hello(){
        System.out.println("hello");
    }
}
