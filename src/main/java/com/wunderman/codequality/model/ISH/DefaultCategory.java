
package com.wunderman.codequality.model.ISH;

import java.util.List;
import javax.annotation.Generated;


@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DefaultCategory {


    private List<CategoryPath> mCategoryPath;

    private String mId;

    private String mName;

    private String mType;

    private String mUri;

    public List<CategoryPath> getCategoryPath() {
        return mCategoryPath;
    }

    public void setCategoryPath(List<CategoryPath> categoryPath) {
        mCategoryPath = categoryPath;
    }

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

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

}
