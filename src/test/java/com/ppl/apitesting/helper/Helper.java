package com.ppl.apitesting.helper;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Helper {
    private static RequestSpecification currentRequest;
    private static Response currentResponse;
    private static ValidatableResponse currentValidatableResponse;

    public static void resetRequest() {
        RestAssured.reset();
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        currentRequest = given().header("Content-Type", "application/json");
    }

    public static RequestSpecification getCurrentRequest() {
        return currentRequest;
    }

    public static void setCurrentRequest(RequestSpecification request) {
        currentRequest = request;
    }

    public static void runCurrentRequest(String url, String method) {
        switch (method) {
            case "GET":
                currentResponse = currentRequest.get(url);
                break;
            case "POST":
                currentResponse = currentRequest.post(url);
                break;
            case "PUT":
                currentResponse = currentRequest.put(url);
                break;
            case "DELETE":
                currentResponse = currentRequest.delete(url);
                break;
            default:
                break;
        }
        currentValidatableResponse = currentResponse.then().assertThat();
    }

    public static String getResponseBody() {
        return currentResponse.getBody().asString();
    }

    public static ValidatableResponse assertResponseThat() {
        return currentValidatableResponse;
    }
}
