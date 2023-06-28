package com.bluckham.util;

import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static final String CHROME = "CHROME";
    public static final String ABS_HREF = "abs:href";
    public static final int DEFAULT_TIMEOUT = 3_000;

    private Constants() {
        // Do nothing
    }
}