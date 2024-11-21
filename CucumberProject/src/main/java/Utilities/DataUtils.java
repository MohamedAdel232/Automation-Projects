package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    private static final String testDataPath = "src/test/resources/TestData/";

    public static String readFromPropertiesFile(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(testDataPath + fileName + ".properties"));
        return properties.getProperty(key);
    }

    public static String readFromJsonFile(String fileName, String key) throws FileNotFoundException {
        FileReader fileReader = new FileReader(testDataPath + fileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        return jsonElement.getAsJsonObject().get(key).getAsString();
    }
}
