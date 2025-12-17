package com.qy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`tb_user`")
public class User {
    private Long id;
    private String loginName;
    private String nickName;
    private String password;
}
