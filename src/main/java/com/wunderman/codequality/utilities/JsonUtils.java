package com.wunderman.codequality.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtils {

    private static final String CLASSNAME = JsonUtils.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private JsonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static JSONObject parseTheJsonResult(String inputJson) {
        String methodName = "parseTheJsonResult(String inputJson)";
        LOGGER.entering(CLASSNAME, methodName);
        LOGGER.log(Level.FINE,inputJson);
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(inputJson);
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, () -> "Parsing error in method parseTheJsonResult: "+ e.getMessage());
        }
        LOGGER.exiting(CLASSNAME, methodName);
        return jsonObject;
    }

}
