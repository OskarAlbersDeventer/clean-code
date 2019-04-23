package com.wunderman.codequality;

import com.wunderman.codequality.model.Category;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock
    IServiceCalls serviceCalls;

    @Before
    public void setUp()throws IOException, URISyntaxException {

        String jsonString = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("category_in.json").toURI())));
        Mockito.when(serviceCalls.getCategories(anyString ())).thenReturn(jsonString);
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

    @Test
    public void testWithNullMock(){
        Mockito.when(serviceCalls.getCategories(anyString())).thenReturn("");
        MainController controller = new MainController(serviceCalls);
        List<Category> result = controller.getCategories();
        Assert.assertEquals("There should be no categories retuned", 0, result.size());

    }

}
