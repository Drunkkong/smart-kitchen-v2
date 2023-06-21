package com.bluckham.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties

public class ConnectionInformation {

    @Getter
    @Value("${database.username}")
    String userName;

    @Getter
    @Value("${database.password}")
    String password;
}
