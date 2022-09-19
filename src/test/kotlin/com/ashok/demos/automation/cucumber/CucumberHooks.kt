package com.ashok.demos.automation.cucumber

import com.ashok.demos.automation.annotation.LazyAutowired
import com.ashok.demos.automation.utils.ScreenshotUtil
import io.cucumber.java.After
import io.cucumber.java.AfterStep
import io.cucumber.java.Scenario
import org.openqa.selenium.WebDriver
import org.springframework.context.ApplicationContext


class CucumberHooks {
    @LazyAutowired
    private var screenshotUtil: ScreenshotUtil? = null

    @LazyAutowired
    private var applicationContext: ApplicationContext? = null

    @AfterStep
    fun afterStep(scenario: Scenario) {
        if (scenario.isFailed) {
            scenario.attach(screenshotUtil?.getScreenshot(), "image/png", scenario.name)
        }
    }

    @After
    fun afterScenario() {
        applicationContext!!.getBean(WebDriver::class.java).quit()
    }
}
