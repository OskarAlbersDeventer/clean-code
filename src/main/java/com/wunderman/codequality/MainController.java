package com.wunderman.codequality;

import com.wunderman.codequality.model.Category;
import com.wunderman.codequality.servicecalls.IntershopCalls;
import com.wunderman.codequality.utilities.ConversionUtils;
import com.wunderman.codequality.utilities.JsonUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class MainController {

    private static final String CLASSNAME = MainController.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);


    @GetMapping("categories")
    public List<Category> getCategories() {
        String methodName = "getCategories()";
        LOGGER.entering(CLASSNAME, methodName);
        List<Category> categoryList = new ArrayList<>();

        String categoryJsonString = IntershopCalls.getCategoriesFromIntershop();
        JSONObject categoryJson = JsonUtils.parseTheJsonResult(categoryJsonString);
        if(categoryJson != null) {
            JSONArray categoryJsonArray = (JSONArray) categoryJson.get("elements");
            LOGGER.log(Level.FINE, ()-> "json array: " + categoryJsonArray.toJSONString());

            for (int i = 0; i < categoryJsonArray.size(); i++) {
                JSONObject category = (JSONObject) categoryJsonArray.get(i);
                LOGGER.log(Level.FINE, () -> "category: " + category.toJSONString());
                categoryList.add(ConversionUtils.convertIntershopCategory(category));
            }
        }

        LOGGER.exiting(CLASSNAME, methodName);
        return categoryList;
    }




}
