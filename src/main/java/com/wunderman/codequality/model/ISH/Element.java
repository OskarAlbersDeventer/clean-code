package com.wunderman.codequality.model.ISH;

import java.util.List;

public class Element {

    private String type;

    private List<Category> elements;

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

    @Override
    public String toString() {
        return getType();
    }
}
