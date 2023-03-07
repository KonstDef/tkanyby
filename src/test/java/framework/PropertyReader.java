package framework;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class PropertyReader{
    private static Properties properties = new Properties();

    public PropertyReader() {
        properties = new Properties();
    }

    public PropertyReader(final String resourceName) {
        properties = appendFromResource(properties, resourceName);
    }


    public PropertyReader(final String defaultResourceName, final String resourceName) {
        this(defaultResourceName);
        properties = appendFromResource(new Properties(properties), resourceName);
    }

    private Properties appendFromResource(final Properties objProperties, final String resourceName) {
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);

        if (inStream != null) {
            try {
                objProperties.load(inStream);
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            log.error(String.format("Resource \"%1$s\" could not be found", resourceName));
        }
        return objProperties;
    }

    public static String getProperty(final String key) {
        return properties.getProperty(key);
    }

    public String getProperty(final String key, final String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public void setProperty(final String key, final String value) {
        properties.setProperty(key, value);
    }

    public static int getIntProperty(final String key) {
        return Integer.parseInt(getProperty(String.valueOf(key)));
    }
    public static Boolean getBooleanProperty(final String key) {
        return Boolean.parseBoolean(getProperty(String.valueOf(key)));
    }
}