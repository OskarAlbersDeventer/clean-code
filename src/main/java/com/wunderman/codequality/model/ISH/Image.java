
package com.wunderman.codequality.model.ISH;

import javax.annotation.Generated;


@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Image {


    private String mEffectiveUrl;

    private Long mImageActualHeight;

    private Long mImageActualWidth;

    private String mName;

    private Boolean mPrimaryImage;

    private String mType;

    private String mTypeID;

    private String mViewID;

    public String getEffectiveUrl() {
        return mEffectiveUrl;
    }

    public void setEffectiveUrl(String effectiveUrl) {
        mEffectiveUrl = effectiveUrl;
    }

    public Long getImageActualHeight() {
        return mImageActualHeight;
    }

    public void setImageActualHeight(Long imageActualHeight) {
        mImageActualHeight = imageActualHeight;
    }

    public Long getImageActualWidth() {
        return mImageActualWidth;
    }

    public void setImageActualWidth(Long imageActualWidth) {
        mImageActualWidth = imageActualWidth;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getPrimaryImage() {
        return mPrimaryImage;
    }

    public void setPrimaryImage(Boolean primaryImage) {
        mPrimaryImage = primaryImage;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getTypeID() {
        return mTypeID;
    }

    public void setTypeID(String typeID) {
        mTypeID = typeID;
    }

    public String getViewID() {
        return mViewID;
    }

    public void setViewID(String viewID) {
        mViewID = viewID;
    }

}
