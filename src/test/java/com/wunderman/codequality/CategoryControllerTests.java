package com.wunderman.codequality;

import com.wunderman.codequality.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTests {

    @Test
    public void testNumberOfConvertedCategories(){
        MainController controller = new MainController();
        List<Category> result =  controller.getCategories();
        Assert.assertEquals(4, result.size());
    }
}
