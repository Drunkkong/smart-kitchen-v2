package com.bluckham.model;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class Meal {
    private MealType type;
    private DayOfWeek day;
    private String url;
}
