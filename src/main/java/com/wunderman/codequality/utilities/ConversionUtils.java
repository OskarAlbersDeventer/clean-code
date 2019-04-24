package com.wunderman.codequality.utilities;

import com.wunderman.codequality.model.Category;

import java.util.logging.Logger;

public class ConversionUtils {

    private static final String CLASSNAME = ConversionUtils.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private ConversionUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Category convertIntershopCategory(com.wunderman.codequality.model.intershop.Category originalCategory){
        String methodName = "convertIntershopCategory(JSONObject categoryJsonObject)";
        LOGGER.entering(CLASSNAME, methodName);
        Category category = new Category();

        if (originalCategory.isHasOnlineSubCategories()) {
            category.setSubcategoriesAvailable(true);
        }

        category.setDescription(originalCategory.getDescription());
        category.setOnline(originalCategory.isHasOnlineProducts());

        category.setId(originalCategory.getId());
        category.setName(originalCategory.getName());

        if ("1".equals(originalCategory.getOnline())) {
            category.setOnline(true);
        }
        category.setUri(originalCategory.getUri());
        category.setSpecial( originalCategory.isHasOnlineProducts() && !originalCategory.isHasOnlineSubCategories());

        LOGGER.exiting(CLASSNAME, methodName);
        return category;
    }
}
