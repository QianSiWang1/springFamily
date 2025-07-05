package com.qy.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String loginName;
    private String nickName;
    private String password;
}
