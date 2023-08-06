package com.bluckham.dao;

import com.bluckham.config.ConnectionInformation;
import com.bluckham.model.Blog;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class KitchenDAO {
    private final Logger logger = Logger.getLogger(KitchenDAO.class.getName());
    private final Connection connection;

    @Autowired
    private ConnectionInformation connectionInformation;

    public KitchenDAO() {
        connection = connect();
    }

    private Connection connect() {
        try(Connection conn = DriverManager.getConnection(connectionInformation.url(), connectionInformation.username(), connectionInformation.password())) {
            logger.log(Level.CONFIG, () -> connectionInformation.url());
            logger.log(Level.CONFIG, () -> connectionInformation.username());
            logger.log(Level.CONFIG, () -> connectionInformation.password());
            logger.info("Connection setup");
            return conn;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            System.exit(500);
        }
        return null;
    }

    public Blog getRandomRecipe() {
        var blog = new Blog();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs ORDER BY RANDOM() LIMIT 1;")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                blog.setName(rs.getString("name"));
                blog.setUrl(rs.getString("url"));
                blog.setQuery(rs.getString("query"));
                blog.setSearchType(rs.getString("searchType"));
            }
        } catch (SQLException sqlException) {
            logger.severe(sqlException.getMessage());
            System.exit(500);
        }
        return blog;
    }

    public String getSpecificBlogRecipe(@NotNull String blogName, @NotNull String recipeName) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT TOP 1 url FROM recipes WHERE blog LIKE ? AND name LIKE ?;")) {
            ps.setString(1, blogName);
            ps.setString(2, recipeName);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
                return rs.getString("url");

        } catch (SQLException sqlException) {
            logger.severe(sqlException.getMessage());
            System.exit(1);
        }
        return null;
    }

    public List<Blog> getAllBlogs() {
        ArrayList<Blog> blogList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var blog = new Blog();
                blog.setName(rs.getString("name"));
                blog.setUrl(rs.getString("url"));
                blog.setQuery(rs.getString("query"));
                blog.setSearchType(rs.getString("searchType"));
                blogList.add(blog);
            }
        } catch (SQLException sqlException) {
            logger.severe(sqlException.getMessage());
            System.exit(1);
        }
        return blogList;
    }
}
