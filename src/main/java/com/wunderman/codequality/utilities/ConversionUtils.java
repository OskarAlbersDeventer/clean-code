package com.wunderman.codequality.utilities;

import com.wunderman.codequality.model.Category;
import org.json.simple.JSONObject;

import java.util.logging.Logger;

public class ConversionUtils {

    private static final String CLASSNAME = ConversionUtils.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private ConversionUtils() {
        throw new IllegalStateException("Utility class");
    }


    public static Category convertIntershopCategory(JSONObject categoryJsonObject) {
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
        if ("1".equals(categoryJsonObject.get("online"))) {
            category.setOnline(true);
        }
        category.setUri((String) categoryJsonObject.get("uri"));
        category.setSpecial((boolean) categoryJsonObject.get("hasOnlineProducts") && !(boolean) categoryJsonObject.get("hasOnlineSubCategories"));

        LOGGER.exiting(CLASSNAME, methodName);
        return category;
    }
}
