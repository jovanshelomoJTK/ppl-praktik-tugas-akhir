package com.ppl.apitesting.hooks;

import com.ppl.apitesting.helper.Helper;

import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void init() {
        Helper.resetRequest();
    }

}
