package com.qy.mybatis;

import com.qy.entity.FlagEntity;
import com.qy.mapper.FlagMapper;
import com.qy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlagTest {
    @Autowired
    FlagMapper flagMapper;

    @Test
    public void test1(){
        FlagEntity flagEntity = new FlagEntity();
        flagEntity.setFlagOne(true);
        flagEntity.setFlagTwo(true);
        flagEntity.setFlagThree(true);
        flagMapper.insertFlag(flagEntity);
    }
}