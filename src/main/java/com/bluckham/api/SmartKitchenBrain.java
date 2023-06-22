package com.bluckham.api;

import com.bluckham.dao.KitchenDAO;
import com.bluckham.dao.WebScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmartKitchenBrain {
    private final KitchenDAO dao = new KitchenDAO();
    private final WebScraper scraper = new WebScraper();

    private static final Logger logger = LoggerFactory.getLogger(SmartKitchenBrain.class);

    public void smartKitchenTest() {
        var blog = dao.getRandomRecipe();
        logger.info("Blog: {}\nRecipes: {}", blog.getName(), scraper.getRandomRecipe(blog));
    }
}
