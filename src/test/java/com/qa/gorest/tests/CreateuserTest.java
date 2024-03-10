package com.qa.gorest.tests;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.pojo.User;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateuserTest extends BaseTest {

    RestClient restClient; // This will create problem since we are adding same object for POST and GET call

    @Test
    public void createUserTest(){
        User user = new User("himanshu", "himanshu@gmail.com", "Male", "Active");
        //restClient = new RestClient();
        Integer userId = restClient.post("/public/v2/users","application/json",user,true )
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().path("id");

        //Get - verify the user

        restClient.get("/public/v2/users"+userId, true)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("id", equalTo(userId));
    }
}
