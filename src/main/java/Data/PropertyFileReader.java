package Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    public  Properties properties;

    public PropertyFileReader(String propertyFile) {
        BufferedReader reader;
       String propertyFilePath = "src/main/resources/PassengerDetails.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null)
            return value;
        else
            throw new RuntimeException("key not specified in the Configuration.properties file.");
    }
    public Properties getAllProperties() {
        if (properties != null)
            return properties;
        else
            throw new RuntimeException("No property specified in the property file.");

    }

}
