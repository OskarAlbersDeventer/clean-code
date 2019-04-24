package com.wunderman.codequality;

import com.wunderman.codequality.model.Category;
import com.wunderman.codequality.model.intershop.CategoryList;
import com.wunderman.codequality.servicecalls.IServiceCalls;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock
    IServiceCalls serviceCalls;

    @Before
    public void setUp()throws IOException, URISyntaxException {

        String jsonString = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("category_in.json").toURI())));
        Mockito.when(serviceCalls.getCategories(anyString ())).thenReturn(createDummyCategoryList());
    }

    private CategoryList createDummyCategoryList(){
        CategoryList categoryList = new CategoryList();
        com.wunderman.codequality.model.intershop.Category category = new com.wunderman.codequality.model.intershop.Category();
        List<com.wunderman.codequality.model.intershop.Category> elements = new ArrayList<>();

        category.setName("Cameras");
        category.setType("Category");
        category.setHasOnlineProducts(false);
        category.setHasOnlineSubCategories(true);
        category.setOnline("1");
        category.setDescription("Category");
        elements.add(category);

        categoryList.setElements(elements);

        return categoryList;
    }

    @Test
    public void testNumberOfConvertedCategories(){
        MainController controller = new MainController();
        List<Category> result =  controller.getCategories();
        Assert.assertEquals("The number of categories should be 4", 4, result.size());
    }

    @Test
    public void testWithIntershopMock(){
        MainController controller = new MainController(serviceCalls);
        List<Category> result = controller.getCategories();
        Assert.assertEquals("The number of categories should be 1", 1, result.size());
    }


}
