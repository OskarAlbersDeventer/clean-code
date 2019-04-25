package com.wunderman.codequality.utilities;

import com.wunderman.codequality.model.Category;

import java.util.logging.Logger;

public class ConversionUtils {

    private static final String CLASSNAME = ConversionUtils.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    /**
     * Create a private no argument constructor so this class can not be initiated
     */
    private ConversionUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method converts an Intershop category POJO to our own model
     * @param originalCategory - The Interhop category POJO
     * @return A category POJO
     */
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
