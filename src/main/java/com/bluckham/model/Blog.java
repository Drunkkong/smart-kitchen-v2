package com.bluckham.model;

import lombok.Data;

public @Data
class Blog {
    private String name;
    private String url;
    private String searchType;
    private String query;
}