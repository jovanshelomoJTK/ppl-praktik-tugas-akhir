package com.ppl.apitesting.stepdefinitions;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import com.ppl.apitesting.helper.Helper;

import io.cucumber.java.en.*;

public class CreateUserStepDefinition {
    @When("/^Mengatur body request dengan data(.*)$/")
    public void Mengatur_body_request_dengan_data(String unused, String bodyData) {
        Helper.setCurrentRequest(Helper.getCurrentRequest().body(bodyData));
    }

    @When("POST request ke {string}")
    public void post_request_ke(String url) {
        Helper.runCurrentRequest(url, "POST");
    }

    @Then("/^Response body yang diterima adalah data user dengan isi(.*)$/")
    public void Response_body_yang_diterima_adalah_data_user(String unused, String expected) throws JSONException {
        String actual = Helper.getResponseBody();
        JSONAssert.assertEquals(expected, actual, false);
    }
}
