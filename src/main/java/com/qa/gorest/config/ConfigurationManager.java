package com.qa.gorest.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationManager {

    private Properties prop;
    private FileInputStream ip;

    public Properties initProp(){
        prop = new Properties();
        try {
            ip = new FileInputStream(".src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
