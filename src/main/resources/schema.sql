CREATE TABLE blogs(name VARCHAR(255) NOT NULL, url VARCHAR(1000) NOT NULL, searchType VARCHAR(50), query VARCHAR(500));
INSERT INTO blogs (name, url, searchType) values ('Minimalist Baker', 'https://minimalistbaker.com/', 's', 'a[href]');
INSERT INTO blogs (name, url, searchType) values ('Avant Garde Vegan', 'https://www.gazoakleychef.com/recipes/', '_sf_s', 'a[href*=/recipes/]');
INSERT INTO blogs (name, url, searchType) values ('Hot For Food', 'https://www.hotforfoodblog.com/', 's', 'a[href*=/recipes/]');
CREATE TABLE inventory(weight FLOAT, count INTEGER, name VARCHAR(255) NOT NULL, description VARCHAR(500), expiration VARCHAR(20), units VARCHAR(255));