package com.qa.gorest.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RestClient {

    private static RequestSpecBuilder specBuilder;
//    private static final String BASE_URI = "https://gorest.co.in";
    private static final String TOKEN_API = "f48640d70ffc83f27432aa5d5d7c44e05572a9a8e8dfb2c0d2bc391a0c907a90";

//    static {
//        specBuilder = new RequestSpecBuilder();
//    }

    private Properties prop;
    private String baseURI;

    public RestClient(Properties prop, String baseURI){
        specBuilder = new RequestSpecBuilder();
        this.prop = prop;
        this.baseURI = baseURI;
    }

    // this method will only be used for GET calls
    private RequestSpecification createRequestSpec() {
        specBuilder.setBaseUri(baseURI)
                .addHeader("Authorization", "Bearer" +" "+ TOKEN_API );
        return specBuilder.build();
    }

    // GET Request with Header as well
    private RequestSpecification createRequestSpec(Map<String, String> headersMap) {
        specBuilder.setBaseUri(baseURI)
                .addHeader("Authorization", "Bearer Token");
        if (headersMap != null) {
            specBuilder.addHeaders(headersMap);
        }
        return specBuilder.build();
    }

    // GET Request with Header and Query Parameter as well
    private RequestSpecification createRequestSpec(Map<String, String> headersMap, Map<String, String> queryParams) {
        specBuilder.setBaseUri(baseURI)
                .addHeader("Authorization", "Bearer Token");
        if (headersMap != null) {
            specBuilder.addHeaders(headersMap);
        }

        if (queryParams != null) {
            specBuilder.addQueryParams(queryParams);
        }
        return specBuilder.build();
    }

    // POST Request with POJO and ContentType as well
    // POST parameter we dont have query param since we are not filtering the data
    private RequestSpecification createRequestSpec(Object requestBody, String contentType) {
        specBuilder.setBaseUri(baseURI)
                .addHeader("Authorization", "Bearer Token");
        specBuilder.setContentType(ContentType.JSON); // There can be multiple content types we can pass accordingly using switch case
        if (requestBody != null) {
            specBuilder.setBody(requestBody);
        }

        return specBuilder.build();
    }

    // POST Request with POJO,ContentType and Headers
    private RequestSpecification createRequestSpec(Object requestBody, String contentType, Map<String, String> headersMap) {
        specBuilder.setBaseUri(baseURI)
                .addHeader("Authorization", "Bearer Token");
        specBuilder.setContentType(ContentType.JSON);

        if (headersMap != null) {
            specBuilder.addHeaders(headersMap);
        }
        if (requestBody != null) {
            specBuilder.setBody(requestBody);
        }
        return specBuilder.build();
    }


    // HTTP Method Utils:

    public Response get(String servicePath, boolean log) {
        if (log) {
            return RestAssured.given(createRequestSpec()).log().all()
                    .when()
                    .get(servicePath);
        } else {
            return RestAssured.given(createRequestSpec())
                    .when()
                    .get(servicePath);
        }
    }

    // get call with headers
    public Response get(String servicePath, Map <String,String> headersMap, boolean log) {
        if (log) {
            return RestAssured.given(createRequestSpec(headersMap)).log().all()
                    .when()
                    .get(servicePath);
        } else {
            return RestAssured.given(createRequestSpec(headersMap))
                    .when()
                    .get(servicePath);
        }
    }

    // get call with query param
    public Response get(String servicePath, Map <String,String> headersMap, Map <String, String> queryParams, boolean log) {
        if (log) {
            return RestAssured.given(createRequestSpec(headersMap,queryParams)).log().all()
                    .when()
                    .get(servicePath);
        } else {
            return RestAssured.given(createRequestSpec(headersMap,queryParams))
                    .when()
                    .get(servicePath);
        }
    }

    public Response post (String servicePath,String contentType, Object requestBody, Map <String,String> headersMap, boolean log){
        if (log){
            return RestAssured.given(createRequestSpec(requestBody,contentType,headersMap)).log().all()
                    .when()
                    .post(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec(requestBody,contentType,headersMap))
                    .when()
                    .post(servicePath);
        }

    }

    // Post request only with content Type and headers
    public Response post (String servicePath,String contentType, Object requestBody,boolean log){
        if (log){
            return RestAssured.given(createRequestSpec(requestBody,contentType)).log().all()
                    .when()
                    .post(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec(requestBody,contentType))
                    .when()
                    .post(servicePath);
        }

}

    public Response put (String servicePath,String contentType, Object requestBody, Map <String,String> headersMap, boolean log){
        if (log){
            return RestAssured.given(createRequestSpec(requestBody,contentType,headersMap)).log().all()
                    .when()
                    .put(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec(requestBody,contentType,headersMap))
                    .when()
                    .put(servicePath);
        }

    }

    // PUT request only with content Type and headers
    public Response put (String servicePath,String contentType, Object requestBody,boolean log){
        if (log){
            return RestAssured.given(createRequestSpec(requestBody,contentType)).log().all()
                    .when()
                    .put(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec(requestBody,contentType))
                    .when()
                    .put(servicePath);
        }

    }

    public Response patch (String servicePath,String contentType, Object requestBody, Map <String,String> headersMap, boolean log){
        if (log){
            return RestAssured.given(createRequestSpec(requestBody,contentType,headersMap)).log().all()
                    .when()
                    .patch(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec(requestBody,contentType,headersMap))
                    .when()
                    .patch(servicePath);
        }

    }

    // PUT request only with content Type and headers
    public Response patch (String servicePath,String contentType, Object requestBody,boolean log){
        if (log){
            return RestAssured.given(createRequestSpec(requestBody,contentType)).log().all()
                    .when()
                    .patch(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec(requestBody,contentType))
                    .when()
                    .patch(servicePath);
        }

    }

    public Response delete (String servicePath,boolean log){
        if (log){
            return RestAssured.given(createRequestSpec()).log().all()
                    .when()
                    .delete(servicePath);
        }
        else{
            return RestAssured.given(createRequestSpec())
                    .when()
                    .delete(servicePath);
        }

    }

}
