package com.wunderman.codequality;

import com.wunderman.codequality.model.Category;
import com.wunderman.codequality.model.intershop.CategoryList;
import com.wunderman.codequality.servicecalls.IServiceCalls;
import com.wunderman.codequality.servicecalls.IntershopCalls;
import com.wunderman.codequality.utilities.ConversionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class MainController {

    private static final String CLASSNAME = MainController.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);
    private static final String HOSTURI = "https://jxdemoserver.intershop.de/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/-/categories";


    IServiceCalls serviceCalls = new IntershopCalls();

    MainController() {
    }

    /**
     * Constructer used for the test cases
     * @param serviceCalls
     */
    MainController(IServiceCalls serviceCalls) {
        this.serviceCalls = serviceCalls;
    }

    /**
     * This method returns all the categories retrieved from the servicecalls in our own model
     * @return
     */
    @GetMapping("categories")
    public List<Category> getCategories() {
        String methodName = "getCategories()";
        LOGGER.entering(CLASSNAME, methodName);
        List<Category> categoryList = new ArrayList<>();

        CategoryList originalCategoryList = serviceCalls.getCategories(HOSTURI);

        if (originalCategoryList != null) {
            for (com.wunderman.codequality.model.intershop.Category originalCategory: originalCategoryList.getElements()) {
                categoryList.add(ConversionUtils.convertIntershopCategory(originalCategory));
            }
        }

        LOGGER.exiting(CLASSNAME, methodName);
        return categoryList;
    }


}
