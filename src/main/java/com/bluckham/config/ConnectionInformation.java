package com.bluckham.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ConnectionInformation {

    @Getter
    @Value("${spring.datasource.username}")
    String username;

    @Getter
    @Value("${spring.datasource.password}")
    String password;

    @Getter
    @Value("${spring.datasource.url}")
    String url;
}
