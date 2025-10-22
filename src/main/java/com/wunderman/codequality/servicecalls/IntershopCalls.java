package com.wunderman.codequality.servicecalls;

import com.wunderman.codequality.model.intershop.CategoryList;
import org.springframework.web.client.RestClient;

public class IntershopCalls implements IServiceCalls{


    /**
     * This method retrieves the categories from Intershop.
     * @param hostUrl - The URL to retrieve the categories
     * @return list of Intershop categorie objects
     */
    @Override
    public CategoryList getCategories(String hostUrl) {
        RestClient restClient = RestClient.builder().baseUrl(hostUrl).build();
        CategoryList result = restClient.get().retrieve().body(CategoryList.class);

       return  result;
    }
}
