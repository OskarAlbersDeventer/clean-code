package com.wunderman.codequality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static final String CLASSNAME = MainController.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);


    @GetMapping("categories")
    public List<Category> getCategories() {
        String methodName = "getCategories()";
        LOGGER.entering(CLASSNAME, methodName);
        List<Category> categoryList = new ArrayList<>();

        String categoryJsonString = getCategoriesFromIntershop();
        JSONObject categoryJson = parseTheJsonResult(categoryJsonString);
        if(categoryJson != null) {
            JSONArray categoryJsonArray = (JSONArray) categoryJson.get("elements");
            LOGGER.log(Level.FINE, ()-> "json array: " + categoryJsonArray.toJSONString());

            for (int i = 0; i < categoryJsonArray.size(); i++) {
                JSONObject category = (JSONObject) categoryJsonArray.get(i);
                LOGGER.log(Level.FINE, () -> "category: " + category.toJSONString());
                categoryList.add(convertIntershopCategory(category));
            }
        }
        LOGGER.exiting(CLASSNAME, methodName);
        return categoryList;
    }

    private static JSONObject parseTheJsonResult(String inputJson) {
        String methodName = "parseTheJsonResult(String inputJson)";
        LOGGER.entering(CLASSNAME, methodName);
        LOGGER.log(Level.FINE,inputJson);
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(inputJson);
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, () -> "Parsing error in method parseTheJsonResult: "+ e.getMessage());
        }
        LOGGER.exiting(CLASSNAME, methodName);
        return jsonObject;
    }

    private static String getCategoriesFromIntershop() {
        String methodName = "getCategoriesFromIntershop";
        LOGGER.entering(CLASSNAME, methodName);
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
            LOGGER.log(Level.FINE, () -> "output json: " + responseString.toString());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, () -> "IO Exception in method getCategoriesFromIntershop: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, () -> "Error in method getCategoriesFromIntershop: " + e.getMessage());
        }

        LOGGER.exiting(CLASSNAME, methodName);
        return responseString.toString();
    }

    private static Category convertIntershopCategory(JSONObject categoryJsonObject) {
        String methodName = "convertIntershopCategory(JSONObject categoryJsonObject)";
        LOGGER.entering(CLASSNAME, methodName);
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

        LOGGER.exiting(CLASSNAME, methodName);
        return category;
    }
}
