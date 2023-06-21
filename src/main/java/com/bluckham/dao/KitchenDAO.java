package com.bluckham.dao;

import com.bluckham.config.ConnectionInformation;
import com.bluckham.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Repository
public class KitchenDAO {
    private final Logger logger = Logger.getLogger(KitchenDAO.class.getName());
    private final Connection connection;

    @Autowired
    ConnectionInformation ci;

    public KitchenDAO() {
        connection = connect();
    }

    private Connection connect() {
        Connection conn = null;
        try {
            var url = "jdbc:postgresql://localhost:2342/inventory";
            conn = DriverManager.getConnection(url, ci.getUserName(), ci.getPassword());
            logger.info("Connection setup");
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            System.exit(500);
        }
        return conn;
    }

    public Blog getRandomRecipe() {
        var blogCount = 0;
        List<Blog> blogList = new ArrayList<>();
        Random rand = null;
        try {
            rand = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            logger.severe(e.getMessage());
            System.exit(1);
        }
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var blog = new Blog();
                blog.setName(rs.getString("name"));
                blog.setUrl(rs.getString("url"));
                blogList.add(blog);
                blogCount++;
            }

        } catch (SQLException sqlException) {
            logger.severe(sqlException.getMessage());
            System.exit(500);
        }
        return blogList.get(rand.nextInt(blogCount));
    }

    // TODO
    public String getSpecificBlogRecipe() {
        return null;
    }
}
