package com.bluckham;

import com.bluckham.api.SmartKitchenBrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SmartKitchen {
    private final SmartKitchenBrain smartKitchenBrain;

    @Autowired
    public SmartKitchen(SmartKitchenBrain smartKitchenBrain) {
        this.smartKitchenBrain = smartKitchenBrain;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartKitchen.class, args);
    }
}