package com.wunderman.codequality.model.intershop;

import java.util.List;

public class CategoryList {

    private List<Category> elements;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Category> getElements() {
        return elements;
    }

    public void setElements(List<Category> elements) {
        this.elements = elements;
    }
}
