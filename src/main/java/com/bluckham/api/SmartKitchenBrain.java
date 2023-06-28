package com.bluckham.api;

import com.bluckham.dao.KitchenDAO;
import com.bluckham.dao.WebScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartKitchenBrain {
    @Autowired
    private KitchenDAO dao;
    @Autowired
    private WebScraper scraper;

    private static final Logger logger = LoggerFactory.getLogger(SmartKitchenBrain.class);

    public void smartKitchenTest() {
        var blog = dao.getRandomRecipe();
        logger.info("Blog: {}\nRecipes: {}", blog.getName(), scraper.getRandomRecipe(blog, "soup"));
    }
}
