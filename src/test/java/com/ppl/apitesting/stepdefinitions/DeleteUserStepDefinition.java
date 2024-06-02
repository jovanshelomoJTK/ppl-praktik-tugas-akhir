package com.ppl.apitesting.stepdefinitions;

import org.json.JSONException;
import org.json.JSONObject;

import com.ppl.apitesting.helper.Helper;

import io.cucumber.java.en.*;

public class DeleteUserStepDefinition {

    String tempUserId;

    @Given("Sudah dibuat data user menggunakan app-id {string}")
    public void sudah_dibuat_data_user(String appId) throws JSONException {
        Helper.setCurrentRequest(Helper.getCurrentRequest().header("app-id", appId)
                .body("{\"firstName\": \"Dummy\",\"lastName\": \"User\",\"email\": \"dummyuser123456@gmail.com\"}"));
        Helper.runCurrentRequest("/user/create", "POST");
        JSONObject response = new JSONObject(Helper.getResponseBody());
        tempUserId = response.getString("id");
        Helper.resetRequest();
    }

    @When("DELETE request ke {string}")
    public void delete_request_ke(String url) {
        Helper.runCurrentRequest(url, "DELETE");
    }

    @When("DELETE request untuk user yang sudah dibuat")
    public void DELETE_request_untuk_user_yang_sudah_dibuat() {
        Helper.runCurrentRequest("/user/" + tempUserId, "DELETE");
    }

    @Then("Response body yang diterima adalah id user yang dihapus")
    public void Response_body_yang_diterima_adalah_id_user_yang_dihapus() {
        Helper.assertResponseThat().body("id", org.hamcrest.Matchers.equalTo(tempUserId));
    }

}
