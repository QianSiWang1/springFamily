package com.qy.service;


import lombok.Data;

@Data
public class User {

    private String name;

    public void init()
    {
        System.out.println("hello");
    }
}
