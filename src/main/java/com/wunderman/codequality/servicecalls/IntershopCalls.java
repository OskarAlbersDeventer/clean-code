package com.wunderman.codequality.servicecalls;

import com.wunderman.codequality.model.intershop.CategoryList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class IntershopCalls implements IServiceCalls{

    private Client client = ClientBuilder.newClient();

    /**
     * This method retrieves the categories from Intershop.
     * @param hostUrl - The URL to retrieve the categories
     * @return list of Intershop categorie objects
     */
    @Override
    public CategoryList getCategories(String hostUrl) {
       CategoryList result =  client.target(hostUrl).request(MediaType.APPLICATION_JSON).get(CategoryList.class);
       return  result;
    }
}
