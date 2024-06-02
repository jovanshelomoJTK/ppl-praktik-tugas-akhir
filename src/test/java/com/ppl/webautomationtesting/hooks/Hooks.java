package com.ppl.webautomationtesting.hooks;

import org.openqa.selenium.TakesScreenshot;

import com.ppl.webautomationtesting.helper.Helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void init() {
        Helper.newDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        // take screenshot if scenario failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Helper.getDriver())
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Helper.getDriver().quit();
    }
}
