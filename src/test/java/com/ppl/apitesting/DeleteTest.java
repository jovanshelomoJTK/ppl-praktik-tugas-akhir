package com.ppl.apitesting;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.hamcrest.Matchers;

class DeleteTest {
    Dotenv dotenv = Dotenv.load();

    // initialize RestAssured
    @BeforeEach
    public void beforeEach() {
        // reset all request specifications
        RestAssured.reset();

        // set url
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    //TC4-01
    @Test
    @DisplayName("Operasi tidak menggunakan app-id")
    void delete_no_app_id() {
        given()
                .header("app-id", "")
                .delete("/user/60d0fe4f5311236168a109fa")
                .then()
                .assertThat()
                .statusCode(403)
                .body("error", Matchers.equalTo("APP_ID_MISSING"));
    }

    //TC4-02
    @Test
    @DisplayName("Operasi menggunakan app-id yang tidak valid")
    void delete_invalid_app_id() {
        given()
                .header("app-id", "abcdef")
                .delete("/user/60d0fe4f5311236168a109fa")
                .then()
                .assertThat()
                .statusCode(403)
                .body("error", Matchers.equalTo("APP_ID_NOT_EXIST"));
    }

    //TC4-03
    @Test
    @DisplayName("Operasi tidak menggunakan user id")
    void delete_no_user_id() {

        given()
                .header("app-id", dotenv.get("APP_ID"))
                .delete("/user/")
                .then()
                .assertThat()
                .statusCode(404)
                .body("error", Matchers.equalTo("PATH_NOT_FOUND"));
    }

    //TC4-04
    @Test
    @DisplayName("Operasi menggunakan id user yang pernah ada di sistem namun sudah dihapus sebelumnya")
    void delete_deleted_user_id() {
        given()
                .header("app-id", dotenv.get("APP_ID"))
                // delete user with id 60d0fe4f5311236168a109fb first
                .delete("/user/60d0fe4f5311236168a109fb");

        // try to delete user with id 60d0fe4f5311236168a109fb again
        given()
                .header("app-id", dotenv.get("APP_ID"))
                .delete("/user/60d0fe4f5311236168a109fb")
                .then()
                .assertThat()
                .statusCode(404)
                .body("error", Matchers.equalTo("RESOURCE_NOT_FOUND"));
    }

    //TC4-05
    @Test
    @DisplayName("Operasi menggunakan id user yang tidak pernah ada di sistem")
    void delete_invalid_user_id() {
        given()
                .header("app-id", dotenv.get("APP_ID"))
                .delete("/user/abcdef")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", Matchers.equalTo("PARAMS_NOT_VALID"));
    }
}
