
package com.wunderman.codequality.model.ISH;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;


@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attribute {


    private String mName;

    private String mType;

    private String mValue;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }


    public String getValue() {
        return mValue;
    }

    @JsonIgnore
    public void setValue(String value) {
        mValue = value;
    }

}
