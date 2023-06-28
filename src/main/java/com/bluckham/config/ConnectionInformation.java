package com.bluckham.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("database")
public record ConnectionInformation(String username, String password, String url) {
}
