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
        if (responseString.length() > 0) {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject tomJsonObject = (JSONObject) jsonParser.parse(responseString.toString());
                System.out.println(tomJsonObject);
                JSONArray tomJsonArray = (JSONArray) tomJsonObject.get("elements");
                System.out.println(tomJsonArray);
                for (int i = 0; i < tomJsonArray.size(); i++) {
                    tomJsonObject = (JSONObject) tomJsonArray.get(i);
                    System.out.println(tomJsonObject);
                    Category c1 = new Category();
                    c1.setId((String) tomJsonObject.get("id"));
                    c1.setName((String) tomJsonObject.get("name"));
                    if (tomJsonObject.get("online").equals("1")) {
                        c1.setOnline(true);
                    }
                    c1.setUri((String) tomJsonObject.get("uri"));
                    c1.setSpecial((boolean) tomJsonObject.get("hasOnlineProducts") && !(boolean) tomJsonObject.get("hasOnlineSubCategories"));
                    categoryList.add(c1);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categoryList;
    }
}
