package com.ppl.apitesting.stepdefinitions;

import com.ppl.apitesting.helper.Helper;

import io.cucumber.java.en.*;

public class UpdateUserStepDefinition {
    @When("PUT request ke {string}")
    public void put_request_ke(String url) {
        Helper.runCurrentRequest(url, "PUT");
    }

    @Then("Response body yang diterima adalah data user dengan first name {string}")
    public void Response_body_yang_diterima_adalah_data_user_dengan_first_name(String s) {
        Helper.assertResponseThat().body("firstName", org.hamcrest.Matchers.equalTo(s));
    }

    
}
