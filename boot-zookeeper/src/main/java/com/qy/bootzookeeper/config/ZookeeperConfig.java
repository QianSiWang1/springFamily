package com.qy.bootzookeeper.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;


@Configuration
@Slf4j
public class ZookeeperConfig {

    @Autowired
    ZkParam wrapperZk;

    /**
     * 这里的start就是创建完对象放到容器后，需要调用他的start方法
     *
     * @return
     */
    @Bean
    public CuratorFramework curatorFramework() {
        // 重试策略：指数退避
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(wrapperZk.getElapsedTimeMs(), wrapperZk.getRetryCount());

        // 创建 Curator 客户端
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(wrapperZk.getConnectString())
                .retryPolicy(retryPolicy)
                .build();

        // 启动客户端
        client.start();
        return client;
    }
}
