package com.ashok.demos.automation.config

import com.ashok.demos.automation.annotation.LazyComponent
import com.ashok.demos.automation.annotation.LazyConfiguration
import com.ashok.demos.automation.annotation.WebdriverScopeBean
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile


@Profile("!grid")
@LazyConfiguration
class WebDriverConfig {
    @WebdriverScopeBean
    @ConditionalOnProperty(name = ["browser"], havingValue = "firefox")
    @Primary
    fun firefoxDriver(): WebDriver {
        return FirefoxDriver()
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = ["browser"], havingValue = "edge")
    @Primary
    fun edgeDriver(): WebDriver {
        return EdgeDriver()
    }

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = ["browser"], havingValue = "chrome")
    @Primary
    fun chromeDriver(): WebDriver {
        return ChromeDriver()
    }
}
