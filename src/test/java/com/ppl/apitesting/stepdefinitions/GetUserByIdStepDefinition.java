package com.ppl.apitesting.stepdefinitions;

import org.hamcrest.Matchers;

import com.ppl.apitesting.helper.Helper;

import io.cucumber.java.en.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserByIdStepDefinition {

    @Given("User dengan id {string} sudah dihapus menggunakan app-id {string}")
    public void User_dengan_id_sudah_dihapus(String userId, String appId) {
        Helper.setCurrentRequest(Helper.getCurrentRequest().header("app-id", appId));
        Helper.runCurrentRequest("/user/" + userId, "DELETE");
        Helper.resetRequest();
    }

    @When("Mengatur app-id dengan {string}")
    public void Mengatur_app_id_dengan(String appId) {
        Helper.setCurrentRequest(Helper.getCurrentRequest().header("app-id", appId));
    }

    @When("GET request ke {string}")
    public void get_request_ke(String url) {
        Helper.runCurrentRequest(url, "GET");
    }

    @Then("Status code yang diterima adalah {int}")
    public void Status_code_yang_diterima_adalah(int i) {
        Helper.assertResponseThat().statusCode(i);
    }

    @Then("Response body yang diterima adalah error message {string}")
    public void Response_body_yang_diterima_adalah_error_message(String error) {
        Helper.assertResponseThat().body("error", Matchers.equalTo(error));
    }

    @Then("Response body yang diterima adalah data user dengan id {string}")
    public void Response_body_yang_diterima_adalah_data_user_dengan_id(String userId) {
        Helper.assertResponseThat().body(matchesJsonSchemaInClasspath("apitesting/schema/user-schema.json"));
        Helper.assertResponseThat().body("id", Matchers.equalTo(userId));
    }

}
