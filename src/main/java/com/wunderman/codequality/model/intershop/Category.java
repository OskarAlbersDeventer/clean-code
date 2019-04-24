package com.wunderman.codequality.model.intershop;

import java.util.List;

public class Category {
    private String name;
    private String type;
    private boolean hasOnlineProducts;
    private boolean hasOnlineSubCategories;
    private String online;
    private String description;
    private List<CategoryPath> categoryPath;
    private String id;
    private String uri;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasOnlineProducts() {
        return hasOnlineProducts;
    }

    public void setHasOnlineProducts(boolean hasOnlineProducts) {
        this.hasOnlineProducts = hasOnlineProducts;
    }

    public boolean isHasOnlineSubCategories() {
        return hasOnlineSubCategories;
    }

    public void setHasOnlineSubCategories(boolean hasOnlineSubCategories) {
        this.hasOnlineSubCategories = hasOnlineSubCategories;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryPath> getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(List<CategoryPath> categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
