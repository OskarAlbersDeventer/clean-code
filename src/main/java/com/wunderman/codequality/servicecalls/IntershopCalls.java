package com.wunderman.codequality.servicecalls;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntershopCalls {

    private static final String CLASSNAME = IntershopCalls.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private IntershopCalls(){
        throw new IllegalStateException("Utility class");
    }

    public static String getCategoriesFromIntershop() {
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
}
