package com.bluckham;

import com.bluckham.api.SmartKitchenBrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartKitchen implements CommandLineRunner {
    @Autowired
    SmartKitchenBrain smartKitchenBrain;

    public static void main(String[] args) {
        SpringApplication.run(SmartKitchen.class, args);
    }
    @Override
    public void run(String... args) {
        smartKitchenBrain.smartKitchenTest();
    }
}