package com.wunderman.codequality.servicecalls;

import com.wunderman.codequality.model.intershop.CategoryList;
import org.springframework.web.client.RestClient;

public class IntershopCalls implements IServiceCalls{

    @Override
    public CategoryList getCategories(String hostUrl) {
        RestClient restClient = RestClient.builder().baseUrl(hostUrl).build();
        CategoryList result = restClient.get().retrieve().body(CategoryList.class);

       return  result;
    }
}
