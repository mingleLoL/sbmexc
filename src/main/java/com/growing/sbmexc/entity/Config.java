package com.growing.sbmexc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/6
 */

@Component
@ConfigurationProperties(prefix = "myEnv")
public class Config {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String name;
    private String port;

}
