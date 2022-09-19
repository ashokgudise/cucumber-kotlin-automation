package com.ashok.demos.automation

import io.cucumber.core.options.Constants
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectDirectories
import org.junit.platform.suite.api.Suite
import org.springframework.boot.test.context.SpringBootTest

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value="com.ashok.demos.automation.cucumber")
@SelectDirectories("src/test/resources/features")
@SpringBootTest
class CucumberKotlinAutomationApplicationTests {

}
