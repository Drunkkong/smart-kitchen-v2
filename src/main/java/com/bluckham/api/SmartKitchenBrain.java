package com.bluckham.api;

import com.bluckham.dao.KitchenDAO;
import com.bluckham.dao.WebScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartKitchenBrain {
    private KitchenDAO dao = new KitchenDAO();
    private WebScraper scraper = new WebScraper();

    private static final Logger logger = LoggerFactory.getLogger(SmartKitchenBrain.class);

    public SmartKitchenBrain() {
        // TODO Fill out method with initial work
    }

    public void smartKitchenTest() {
        var blog = dao.getRandomRecipe();
        logger.info("Blog: " + blog.getName() + "\nRecipes: " + scraper.getRandomRecipe(blog));
    }
}
