package com.qy.bootzookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class ZkParam {
    private int retryCount;
    private int elapsedTimeMs;
    private String connectString;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
}
