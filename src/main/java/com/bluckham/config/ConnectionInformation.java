package com.bluckham.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ConnectionInformation {

    @Value("${database.username}")
    String userName;

    @Value("${database.password}")
    String password;
}
