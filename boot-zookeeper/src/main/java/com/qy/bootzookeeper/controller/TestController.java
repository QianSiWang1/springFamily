package com.qy.bootzookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class TestController {
    @Autowired
    CuratorFramework curatorFramework;

    @GetMapping("/zk/test")
    public void getUser() throws Exception {
        // 添加持久节点
//        String path = curatorFramework.create().forPath("/curator-node");
//        System.out.println(String.format("curator create node :%s successfully.", path));
//
//        // 添加临时序号节点,并赋值数据
//        String path1 = curatorFramework.create()
//                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
//                .forPath("/curator-node", "some-data".getBytes());
//        System.out.println(String.format("curator create node :%s successfully.", path));
        curatorFramework.setData().forPath("/curator-node", "changed!".getBytes());
        byte[] bytes = curatorFramework.getData().forPath("/curator-node");
        System.out.println(new String(bytes));
    }

}
