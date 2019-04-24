package com.wunderman.codequality.servicecalls;

import com.wunderman.codequality.model.intershop.CategoryList;

public interface IServiceCalls {

    CategoryList getCategories(String hostUrl);
}
