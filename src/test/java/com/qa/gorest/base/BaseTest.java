package com.qa.gorest.base;
import java.util.Properties;

import com.qa.gorest.client.RestClient;
import com.qa.gorest.config.ConfigurationManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected ConfigurationManager config;
    protected Properties prop;
    protected RestClient restClient ;
    @BeforeTest
    public void setUp(){

        // This is used for Allure Reporting
        RestAssured.filters(new AllureRestAssured());

        config = new ConfigurationManager();
        prop= config.initProp();
        String baseURI = prop.getProperty("baseURI");
        restClient = new RestClient(prop,baseURI);

    }
}
