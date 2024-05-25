package com.ppl.apitesting;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.hamcrest.Matchers;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class CreateTest {
        Dotenv dotenv = Dotenv.load();

        // initialize RestAssured
        @BeforeEach
        public void beforeEach() {
                // reset all request specifications
                RestAssured.reset();

                // set url
                RestAssured.baseURI = "https://dummyapi.io/data/v1";
        }

        // string generator untuk test pembuatan email (karena email tidak dapat double)
        private String generateRandomEmail() {
                String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
                StringBuilder sb = new StringBuilder();
                Random rnd = new Random();
                while (sb.length() < 18) { // length of the random string.
                        int index = (int) (rnd.nextFloat() * chars.length());
                        sb.append(chars.charAt(index));
                }
                String saltStr = sb.toString();
                return saltStr + "@gmail.com";
        }

        // TC2-01
        @Test
        @DisplayName("Operasi tidak menggunakan app-id")
        void create_no_app_id() {
                given()
                                .header("Content-Type", "application/json")
                                .body("{\n" +
                                                "  \"title\": \"mrs\",\n" +
                                                "  \"firstName\": \"Jennie\",\n" +
                                                "  \"lastName\": \"Kim\",\n" +
                                                "  \"gender\": \"female\",\n" +
                                                "  \"email\": \"jenniekim@example.com\",\n" +
                                                "  \"dateOfBirth\": \"1996-01-16T00:00:00.000Z\",\n" +
                                                "  \"phone\": \"+1234567890\",\n" +
                                                "  \"picture\": \"https://id.wikipedia.org/wiki/Jennie_(penyanyi)\",\n"
                                                +
                                                "  \"location\": {\n" +
                                                "    \"street\": \"Jalan\",\n" +
                                                "    \"city\": \"Bandung\",\n" +
                                                "    \"state\": \"Jawa Barat\",\n" +
                                                "    \"country\": \"Indonesia\",\n" +
                                                "    \"timezone\": \"+7:00\"\n" +
                                                "  }\n" +
                                                "}")
                                .post("/user/create")
                                .then()
                                .assertThat()
                                .statusCode(403)
                                .body("error", Matchers.equalTo("APP_ID_MISSING"));
        }

        // TC2-02
        @Test
        @DisplayName("Operasi menggunakan app-id yang tidak valid")
        void create_invalid_app_id() {
                given()
                                .header("app-id", "abcdef")
                                .header("Content-Type", "application/json")
                                .body("{\n" +
                                                "  \"title\": \"mrs\",\n" +
                                                "  \"firstName\": \"Jennie\",\n" +
                                                "  \"lastName\": \"Kim\",\n" +
                                                "  \"gender\": \"female\",\n" +
                                                "  \"email\": \"jenniekim@example.com\",\n" +
                                                "  \"dateOfBirth\": \"1996-01-16T00:00:00.000Z\",\n" +
                                                "  \"phone\": \"+1234567890\",\n" +
                                                "  \"picture\": \"https://id.wikipedia.org/wiki/Jennie_(penyanyi)\",\n"
                                                +
                                                "  \"location\": {\n" +
                                                "    \"street\": \"Jalan\",\n" +
                                                "    \"city\": \"Bandung\",\n" +
                                                "    \"state\": \"Jawa Barat\",\n" +
                                                "    \"country\": \"Indonesia\",\n" +
                                                "    \"timezone\": \"+7:00\"\n" +
                                                "  }\n" +
                                                "}")
                                .post("/user/create")
                                .then()
                                .assertThat()
                                .statusCode(403)
                                .body("error", Matchers.equalTo("APP_ID_NOT_EXIST"));
        }

        // TC2-03
        @Test
        @DisplayName("Membuat user dengan seluruh field valid dengan data input first name, last name, dan email valid")
        void create_valid_user() {
                // generate random string for email
                String randomEmail = generateRandomEmail();
                given()
                                .header("app-id", dotenv.get("APP_ID"))
                                .header("Content-Type", "application/json")
                                .body("{\n" +
                                                "  \"title\": \"mrs\",\n" +
                                                "  \"firstName\": \"Jennie\",\n" +
                                                "  \"lastName\": \"Kim\",\n" +
                                                "  \"gender\": \"female\",\n" +
                                                "  \"email\": \"" + randomEmail + "\",\n" +
                                                "  \"dateOfBirth\": \"1996-01-16T00:00:00.000Z\",\n" +
                                                "  \"phone\": \"+1234567890\",\n" +
                                                "  \"picture\": \"https://id.wikipedia.org/wiki/Jennie_(penyanyi)\",\n"
                                                +
                                                "  \"location\": {\n" +
                                                "    \"street\": \"Jalan\",\n" +
                                                "    \"city\": \"Bandung\",\n" +
                                                "    \"state\": \"Jawa Barat\",\n" +
                                                "    \"country\": \"Indonesia\",\n" +
                                                "    \"timezone\": \"+7:00\"\n" +
                                                "  }\n" +
                                                "}")
                                .post("/user/create")
                                .then()
                                .assertThat()
                                .body(matchesJsonSchemaInClasspath("user-schema.json"))
                                .statusCode(200)
                                .body("title", Matchers.equalTo("mrs"))
                                .body("firstName", Matchers.equalTo("Jennie"))
                                .body("lastName", Matchers.equalTo("Kim"))
                                .body("gender", Matchers.equalTo("female"))
                                .body("email", Matchers.equalTo(randomEmail))
                                .body("dateOfBirth", Matchers.equalTo("1996-01-16T00:00:00.000Z"))
                                .body("phone", Matchers.equalTo("+1234567890"))
                                .body("picture", Matchers.equalTo("https://id.wikipedia.org/wiki/Jennie_(penyanyi)"))
                                .body("location.street", Matchers.equalTo("Jalan"))
                                .body("location.city", Matchers.equalTo("Bandung"))
                                .body("location.state", Matchers.equalTo("Jawa Barat"))
                                .body("location.country", Matchers.equalTo("Indonesia"))
                                .body("location.timezone", Matchers.equalTo("+7:00"));

        }

        // TC2-04
        @Test
        @DisplayName("Membuat user dengan seluruf field valid dengan data input hanya berisi first name dan last name valid tanpa email")
        void create_invalid_user_without_email() {
                given()
                                .header("app-id", dotenv.get("APP_ID"))
                                .header("Content-Type", "application/json")
                                .body("{\n" +
                                                "  \"title\": \"mrs\",\n" +
                                                "  \"firstName\": \"Jennie\",\n" +
                                                "  \"lastName\": \"Kim\",\n" +
                                                "  \"gender\": \"female\",\n" +
                                                "  \"dateOfBirth\": \"1996-01-16T00:00:00.000Z\",\n" +
                                                "  \"phone\": \"+1234567890\",\n" +
                                                "  \"picture\": \"https://id.wikipedia.org/wiki/Jennie_(penyanyi)\",\n"
                                                +
                                                "  \"location\": {\n" +
                                                "    \"street\": \"Jalan\",\n" +
                                                "    \"city\": \"Bandung\",\n" +
                                                "    \"state\": \"Jawa Barat\",\n" +
                                                "    \"country\": \"Indonesia\",\n" +
                                                "    \"timezone\": \"+7:00\"\n" +
                                                "  }\n" +
                                                "}")
                                .post("/user/create")
                                .then()
                                .assertThat()
                                .statusCode(400)
                                .body("error", Matchers.equalTo("BODY_NOT_VALID"));
        }

        // TC2-05
        @Test
        @DisplayName("Membuat user dengan seluruh field valid dengan data input hanya berisi first name dan email valid tanpa last name")
        void create_invalid_user_without_lastname() {
                given()
                                .header("app-id", dotenv.get("APP_ID"))
                                .header("Content-Type", "application/json")
                                .body("{\n" +
                                                "  \"title\": \"mrs\",\n" +
                                                "  \"firstName\": \"Jennie\",\n" +
                                                "  \"gender\": \"female\",\n" +
                                                "  \"email\": \"jenniekim@example.com\",\n" +
                                                "  \"dateOfBirth\": \"1996-01-16T00:00:00.000Z\",\n" +
                                                "  \"phone\": \"+1234567890\",\n" +
                                                "  \"picture\": \"https://id.wikipedia.org/wiki/Jennie_(penyanyi)\",\n"
                                                +
                                                "  \"location\": {\n" +
                                                "    \"sreet\": \"Jalan\",\n" +
                                                "    \"city\": \"Bandung\",\n" +
                                                "    \"state\": \"Jawa Barat\",\n" +
                                                "    \"country\": \"Indonesia\",\n" +
                                                "    \"timezone\": \"+7:00\"\n" +
                                                "  }\n" +
                                                "}")
                                .post("/user/create")
                                .then()
                                .assertThat()
                                .statusCode(400)
                                .body("error", Matchers.equalTo("BODY_NOT_VALID"));
        }
}
