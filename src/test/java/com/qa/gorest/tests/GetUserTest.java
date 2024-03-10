package com.qa.gorest.tests;
import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {
    RestClient restClient;

    @Test
    public void getAllUsersTest(){
        restClient.get("/public/v2/users",true)
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getSpecificUserTest(){
        restClient.get("/public/v2/users/989999",true)
                .then().log().all()
                .assertThat().statusCode(200)
                .and().body("id", equalTo(989999));
    }

    @Test
    public void getSpecificUserTestWIthQueryParam(){
        HashMap <String,String> queryParams = new HashMap<>();
        queryParams.put("","");
        queryParams.put("","");
        restClient.get("/public/v2/users/989999",null,queryParams, true)
                .then().log().all()
                .assertThat().statusCode(200)
                .and().body("id", equalTo(989999));
    }



}
