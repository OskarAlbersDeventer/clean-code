
package com.wunderman.codequality.model.ISH;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetails {

    private List<Attribute> attributes;

    private Boolean mAvailability;


    private Long mAvailableStock;

    private DefaultCategory mDefaultCategory;

    private List<Image> mImages;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    private Boolean mInStock;

    private ListPrice mListPrice;

    private String mLongDescription;

    private String mManufacturer;

    private Long mMaxOrderQuantity;

    private Long mMinOrderQuantity;

    private String mName;

    private String mProductName;


    private SalePrice mSalePrice;

    private String mShortDescription;

    private String mSku;

    private Long mStepOrderQuantity;

    private String mType;



    public Boolean getAvailability() {
        return mAvailability;
    }

    public void setAvailability(Boolean availability) {
        mAvailability = availability;
    }

    public Long getAvailableStock() {
        return mAvailableStock;
    }

    public void setAvailableStock(Long availableStock) {
        mAvailableStock = availableStock;
    }

    public DefaultCategory getDefaultCategory() {
        return mDefaultCategory;
    }

    public void setDefaultCategory(DefaultCategory defaultCategory) {
        mDefaultCategory = defaultCategory;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public Boolean getInStock() {
        return mInStock;
    }

    public void setInStock(Boolean inStock) {
        mInStock = inStock;
    }

    public ListPrice getListPrice() {
        return mListPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        mListPrice = listPrice;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setLongDescription(String longDescription) {
        mLongDescription = longDescription;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public void setManufacturer(String manufacturer) {
        mManufacturer = manufacturer;
    }


    public Long getMaxOrderQuantity() {
        return mMaxOrderQuantity;
    }

    public void setMaxOrderQuantity(Long maxOrderQuantity) {
        mMaxOrderQuantity = maxOrderQuantity;
    }

    public Long getMinOrderQuantity() {
        return mMinOrderQuantity;
    }

    public void setMinOrderQuantity(Long minOrderQuantity) {
        mMinOrderQuantity = minOrderQuantity;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }


    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public SalePrice getSalePrice() {
        return mSalePrice;
    }

    public void setSalePrice(SalePrice salePrice) {
        mSalePrice = salePrice;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getSku() {
        return mSku;
    }

    public void setSku(String sku) {
        mSku = sku;
    }

    public Long getStepOrderQuantity() {
        return mStepOrderQuantity;
    }

    public void setStepOrderQuantity(Long stepOrderQuantity) {
        mStepOrderQuantity = stepOrderQuantity;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
