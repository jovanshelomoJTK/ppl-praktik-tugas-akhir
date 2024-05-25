package com.ppl.apitesting;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.hamcrest.Matchers;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class GetTest {
    Dotenv dotenv = Dotenv.load();

    // initialize RestAssured
    @BeforeEach
    public void beforeEach() {
        // reset all request specifications
        RestAssured.reset();

        // set url
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    // TC1-01
    @Test
    @DisplayName("Operasi tidak menggunakan app-id")
    void get_no_app_id() {
        given()
                .get("/user/60d0fe4f5311236168a109ca")
                .then()
                .assertThat()
                .statusCode(403)
                .body("error", Matchers.equalTo("APP_ID_MISSING"));
    }

    // TC1-02
    @Test
    @DisplayName("Operasi menggunakan app-id yang tidak valid")
    void get_invalid_app_id() {
        given()
                .header("app-id", "abcdef")
                .get("/user/60d0fe4f5311236168a109ca")
                .then()
                .assertThat()
                .statusCode(403)
                .body("error", Matchers.equalTo("APP_ID_NOT_EXIST"));
    }

    // TC1-03
    @Test
    @DisplayName("Operasi menggunakan app-id yang valid namun menggunakan id user yang tidak valid (tidak ada pada sistem)")
    void get_invalid_user_id() {
        given()
                .header("app-id", dotenv.get("APP_ID"))
                .get("/user/abcdef")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", Matchers.equalTo("PARAMS_NOT_VALID"));
    }

    // TC1-04
    @Test
    @DisplayName("Operasi menggunakan app-id yang valid dan  menggunakan id user yang  valid (ada pada sistem)")
    void get_valid_user_id() {
        given()
                .header("app-id", "662cdc89690e960a6c71037a")
                .get("/user/60d0fe4f5311236168a109ca")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("user-schema.json"));
    }
}
