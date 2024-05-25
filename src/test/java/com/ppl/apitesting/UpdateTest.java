package com.ppl.apitesting;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.hamcrest.Matchers;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class UpdateTest {
    Dotenv dotenv = Dotenv.load();

    // initialize RestAssured
    @BeforeEach
    public void beforeEach() {
        // reset all request specifications
        RestAssured.reset();

        // set url
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    // TC3-01
    @Test
    @DisplayName("Operasi tidak menggunakan app-id")
    void update_no_app_id() {
        given()
                .put("/user/60d0fe4f5311236168a109cb")
                .then()
                .assertThat()
                .statusCode(403)
                .body("error", Matchers.equalTo("APP_ID_MISSING"));
    }

    // TC3-02
    @Test
    @DisplayName("Operasi menggunakan app-id yang tidak valid")
    void update_invalid_app_id() {
        given()
                .header("app-id", "abcdef")
                .put("/user/60d0fe4f5311236168a109cb")
                .then()
                .assertThat()
                .statusCode(403)
                .body("error", Matchers.equalTo("APP_ID_NOT_EXIST"));
    }

    // TC3-03
    @Test
    @DisplayName("Operasi menggunakan app-id yang valid namun tidak menggunakan id user")
    void update_no_user_id() {
        given()
                .header("app-id", dotenv.get("APP_ID"))
                .put("/user/")
                .then()
                .assertThat()
                .statusCode(404)
                .body("error", Matchers.equalTo("PATH_NOT_FOUND"));
    }

    // TC3-04
    @Test
    @DisplayName("Operasi menggunakan app-id yang valid namun menggunakan id user yang tidak valid (tidak ada pada sistem)")
    void update_invalid_user_id() {
        given()
                .header("app-id", dotenv.get("APP_ID"))
                .put("/user/abcdef")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", Matchers.equalTo("PARAMS_NOT_VALID"));
    }

    // TC3-39
    @Test
    @DisplayName("Update title  user dengan data valid (\"mr\", \"ms\", \"mrs\", \"miss\", \"dr\", \"\"), menggunakan header app-id yang valid dan id user yang valid")
    void update_user_title() {
        given()
                .header("app-id", dotenv.get("APP_ID"))
                .header("Content-Type", "application/json")
                .body("{\"title\":\"miss\"}")
                .put("/user/60d0fe4f5311236168a109cc")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user-schema.json"))
                .statusCode(200)
                .body("title", Matchers.equalTo("miss"));
    }
}
