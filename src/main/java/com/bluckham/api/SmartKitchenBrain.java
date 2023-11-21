package com.bluckham.api;

import com.bluckham.dao.KitchenDAO;
import com.bluckham.dao.WebScraper;
import com.bluckham.model.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class SmartKitchenBrain {
    private final KitchenDAO dao;
    private final WebScraper scraper;

    @Autowired
    public SmartKitchenBrain(KitchenDAO dao, WebScraper webScraper) {
        this.dao = dao;
        this.scraper = webScraper;
    }
    private static final Logger logger = LoggerFactory.getLogger(SmartKitchenBrain.class);

    @GetMapping(value="/randomRecipe/{searchParameter}")
    public String getRecipe(@PathVariable String searchParameter) {
        logger.debug("Get Random Recipe");
        var blog = dao.getRandomRecipe();
        return scraper.getRandomRecipe(blog, searchParameter);
    }

    @GetMapping(value="/weeklyMeals")
    public Map<DayOfWeek, List<Meal>> weeklyMeals() {
        logger.debug("Weekly Meals");
        var blogList = dao.getAllBlogs();
        Map<DayOfWeek, List<Meal>> weeklyMeals = scraper.getWeeklyMeals(blogList);
        return Collections.unmodifiableMap(weeklyMeals);
    }
}
