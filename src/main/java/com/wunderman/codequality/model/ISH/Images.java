package com.wunderman.codequality.model.ISH;

public class Images {

    private String name;

    private String type;

    private String effectiveUrl;

    private String viewID;

    private String typeID;

    private String imageActualHeight;

    private String imageActualWidth;

    private String primaryImage;


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

    public String getEffectiveUrl() {
        return effectiveUrl;
    }

    public void setEffectiveUrl(String effectiveUrl) {
        this.effectiveUrl = effectiveUrl;
    }

    public String getViewID() {
        return viewID;
    }

    public void setViewID(String viewID) {
        this.viewID = viewID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getImageActualHeight() {
        return imageActualHeight;
    }

    public void setImageActualHeight(String imageActualHeight) {
        this.imageActualHeight = imageActualHeight;
    }

    public String getImageActualWidth() {
        return imageActualWidth;
    }

    public void setImageActualWidth(String imageActualWidth) {
        this.imageActualWidth = imageActualWidth;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    @Override
    public String toString() {
        return getName();
    }
}
