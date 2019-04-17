package com.wunderman.codequality.model.ISH;

import java.util.List;

public class ProductList {

    private List<Product> elements;
    private String name;
    private String type;

    public List<Product> getElements() {
        return elements;
    }

    public void setElements(List<Product> elements) {
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
