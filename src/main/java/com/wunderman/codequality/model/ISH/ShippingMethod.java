
package com.wunderman.codequality.model.ISH;

import javax.annotation.Generated;


@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ShippingMethod {


    private String mId;

    private String mName;

    private Long mShippingTimeMax;

    private Long mShippingTimeMin;

    private String mType;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getShippingTimeMax() {
        return mShippingTimeMax;
    }

    public void setShippingTimeMax(Long shippingTimeMax) {
        mShippingTimeMax = shippingTimeMax;
    }

    public Long getShippingTimeMin() {
        return mShippingTimeMin;
    }

    public void setShippingTimeMin(Long shippingTimeMin) {
        mShippingTimeMin = shippingTimeMin;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
