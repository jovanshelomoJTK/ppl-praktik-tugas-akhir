package com.ppl.apitesting;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/apitesting/features"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.ppl.apitesting"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,"
                + "junit:target/cucumber-reports-api/Cucumber.xml,"
                + "json:target/cucumber-reports-api/Cucumber.json,"
                + "html:target/cucumber-reports-api/Cucumber.html,"
                + "timeline:target/cucumber-reports-api/CucumberTimeline")
})
public class RunApiTest {
}
