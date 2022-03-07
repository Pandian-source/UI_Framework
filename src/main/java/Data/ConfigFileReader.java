package Data;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    public static Properties prop;

    private final String propertyFilePath = "./src/main/resources/Configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            prop = new Properties();
            try {
                prop.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }

    }

    public String getBrowserName() {
        String url = prop.getProperty("browser");
        if (url != null)
            return url;
        else
            throw new RuntimeException("browser not specified in the Configuration.properties file.");
    }

    public String dimension() {
        String dim = prop.getProperty("dimension");
        if (dim != null)
            return dim;
        else
            throw new RuntimeException("dimension not specified in the Configuration.properties file.");

    }
    public String getBaseDir() {
        String dir = System.getProperty("user.dir");
        if (dir != null) {
            return dir;
        } else
            throw new RuntimeException("base dir not specified in the Configuration.properties file.");
    }
    public String getApplicationUrl() {
        String url = prop.getProperty("site.url");
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String userName() {
        String username = prop.getProperty("username");
        if (username != null)
            return username;
        else
            throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }
    public String passWord() {
        String password = prop.getProperty("password");
        if (password != null)
            return password;
        else
            throw new RuntimeException("passWord not specified in the Configuration.properties file.");
    }
    public String locationValid() {
        String locationvalid = prop.getProperty("locationvalid");
        if (locationvalid != null)
            return locationvalid;
        else
            throw new RuntimeException("locationvalid not specified in the Configuration.properties file.");
    }
    public String locationInvalid() {
        String locationinvalid = prop.getProperty("locationinvalid");
        if (locationinvalid != null)
            return locationinvalid;
        else
            throw new RuntimeException("locationInvalid not specified in the Configuration.properties file.");
    }
    public String checkIn() {
        String checkin = prop.getProperty("checkin");
        if (checkin != null)
            return checkin;
        else
            throw new RuntimeException("checkin not specified in the Configuration.properties file.");
    }
    public String checkOut() {
        String checkout = prop.getProperty("checkout");
        if (checkout != null)
            return checkout;
        else
            throw new RuntimeException("checkin not specified in the Configuration.properties file.");
    }
    public String getProperty(String key) {
        String value = prop.getProperty(key);
        if (value != null)
            return value;
        else
            throw new RuntimeException("key not specified in the Configuration.properties file.");
    }
    public String firstName() {
        String firstname = prop.getProperty("firstname");
        if (firstname != null)
            return firstname;
        else
            throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }

    public String lastName() {
        String lastname = prop.getProperty("lastname");
        if (lastname != null)
            return lastname;
        else
            throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }
    public String phoneNumber() {
        String phonenumber = prop.getProperty("phonenumber");
        if (phonenumber != null)
            return phonenumber;
        else
            throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }
    public String emailId() {
        String emailid = prop.getProperty("emailid");
        if (emailid != null)
            return emailid;
        else
            throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }



}
