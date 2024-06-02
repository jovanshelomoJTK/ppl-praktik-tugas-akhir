package com.ppl.webautomationtesting;

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
                @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/webautomationtesting/features"),
                @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.ppl.webautomationtesting"),
                @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,"
                                + "junit:target/cucumber-reports-web/Cucumber.xml,"
                                + "json:target/cucumber-reports-web/Cucumber.json,"
                                + "html:target/cucumber-reports-web/Cucumber.html,"
                                + "timeline:target/cucumber-reports-web/CucumberTimeline")
})
public class RunWebTest {
}
