package com.wunderman.codequality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wunderman.codequality.model.Category;


@RestController
public class MainController {

    @GetMapping("categories")
    public List<Category> getCategories() {
        System.out.println("Starting getCategories");
        List<Category> categoryList = new ArrayList<>();

        String categoryJsonString = getCategoriesFromIntershop();
        JSONObject categoryJson = parseTheJsonResult(categoryJsonString);
        if(categoryJson != null) {
            JSONArray categoryJsonArray = (JSONArray) categoryJson.get("elements");
            System.out.println(categoryJsonArray);
            for (int i = 0; i < categoryJsonArray.size(); i++) {
                JSONObject category = (JSONObject) categoryJsonArray.get(i);
                System.out.println(category);
                categoryList.add(convertIntershopCategory(category));
            }
        }
        return categoryList;
    }

    private static JSONObject parseTheJsonResult(String inputJson) {
        System.out.println(inputJson);
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(inputJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private static String getCategoriesFromIntershop() {
        StringBuilder responseString = new StringBuilder();

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://jxdemoserver6.intershop.de/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/-/categories");
            HttpResponse response = client.execute(request);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseString.append(line);
            }
            System.out.println(responseString);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseString.toString();
    }

    private static Category convertIntershopCategory(JSONObject categoryJsonObject) {
        Category category = new Category();
        if ((boolean) categoryJsonObject.get("hasOnlineSubCategories")) {
            category.setSubcategoriesAvailable(true);
        }
        category.setDescription((String) categoryJsonObject.get("description"));
        category.setOnline((boolean) categoryJsonObject.get("hasOnlineProducts"));

        category.setId((String) categoryJsonObject.get("id"));
        category.setName((String) categoryJsonObject.get("name"));
        if (categoryJsonObject.get("online").equals("1")) {
            category.setOnline(true);
        }
        category.setUri((String) categoryJsonObject.get("uri"));
        category.setSpecial((boolean) categoryJsonObject.get("hasOnlineProducts") && !(boolean) categoryJsonObject.get("hasOnlineSubCategories"));

        return category;
    }
}
