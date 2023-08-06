package com.bluckham.dao;

import com.bluckham.model.Blog;
import com.bluckham.util.Constants;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
}
