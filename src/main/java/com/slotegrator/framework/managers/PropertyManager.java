package com.slotegrator.framework.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager propertyManager = null;
    private Properties properties = new Properties();

    private PropertyManager() {
        loadPropertiesFromFile();
        loadCustomProperties();
    }

    public static PropertyManager getPropertyManager() {
        if (propertyManager == null) {
            propertyManager = new PropertyManager();
        }
        return propertyManager;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadPropertiesFromFile() {
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomProperties() {
        for (Map.Entry<Object, Object> propertyFromFile : properties.entrySet()) {
            for (Map.Entry<Object, Object> systemProperty : System.getProperties().entrySet()) {
                if ((propertyFromFile.getKey().toString()).equals(systemProperty.getKey().toString())
                        &&
                        !((propertyFromFile.getValue().toString()).equals(systemProperty.getValue().toString()))
                ) {
                    properties.setProperty(propertyFromFile.getKey().toString(), systemProperty.getValue().toString());
                }
            }
        }
    }
}
