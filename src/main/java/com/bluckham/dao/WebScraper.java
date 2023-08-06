package com.bluckham.dao;

import com.bluckham.model.Blog;
import com.bluckham.model.Meal;
import com.bluckham.model.MealType;
import com.bluckham.util.Constants;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.*;
import java.util.logging.Logger;

@Component
public class WebScraper {
    private static final Logger logger = Logger.getLogger(WebScraper.class.getName());

    public String getRandomRecipe(@NotNull Blog blog, @NotNull String keyword) {
        Document document = null;
        Set<String> recipeSet = new HashSet<>();
        var rand = new Random(System.currentTimeMillis());
        try {
            document =
                    Jsoup.connect(blog.getUrl()).data(blog.getSearchType(), keyword).userAgent(Constants.CHROME).timeout(Constants.DEFAULT_TIMEOUT).get();
        } catch (IOException e) {
            logger.severe(e.getMessage());
            System.exit(1);
        }

        for (Element element : document.select(blog.getQuery()))
            recipeSet.add(element.attr(Constants.ABS_HREF));

        return (String) recipeSet.toArray()[rand.nextInt(recipeSet.size())];
    }

    // TODO Test this feature. Likely not right return
    public String getSpecificRecipe(@NotNull String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).userAgent(Constants.CHROME).timeout(Constants.DEFAULT_TIMEOUT).get();
        } catch (IOException ioException) {
            logger.severe(ioException.getMessage());
            System.exit(1);
        }

        return document.data();
    }

    // TODO Look to reduce looping
    public Map<DayOfWeek, List<Meal>> getWeeklyMeals(@NotNull List<Blog> blogList) {
        EnumMap<DayOfWeek, List<Meal>> weekOfMeals = new EnumMap<>(DayOfWeek.class);
        var rand = new Random(System.currentTimeMillis());
        ArrayList<Meal> mealsOfDay;

        for (DayOfWeek day : DayOfWeek.values()) {
            mealsOfDay = new ArrayList<>();
            var meal = new Meal();

            for (MealType type : MealType.values()) {
                meal.setDay(day);
                meal.setType(type);
                meal.setUrl(getRandomRecipe(blogList.get(rand.nextInt(blogList.size())), type.getValue()));

                mealsOfDay.add(meal);
            }

            weekOfMeals.put(day, mealsOfDay);
        }
        return weekOfMeals;
    }
}
