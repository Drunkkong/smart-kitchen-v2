package com.bluckham.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
public record ConnectionInformation(String username, String password, String url) {
}
