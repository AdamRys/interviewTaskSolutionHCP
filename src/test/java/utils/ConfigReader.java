package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//This class is created to get data like credential from config file - created to manage "secure" data
public class ConfigReader {
    private static final Properties properties = new Properties();

    //Loading config file
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            fis.close();
        }catch (IOException e){
            throw new RuntimeException("Couldn't load config");
        }
    }

    //Provide key -> get value method
    public static String get(String key){
        String value = properties.getProperty(key);
        if(value==null){
            throw new RuntimeException("No value for key:" + key);
        }
        return value;
    }
}
