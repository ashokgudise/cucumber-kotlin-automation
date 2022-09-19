package com.ashok.demos.automation.config

import com.ashok.demos.automation.annotation.LazyConfiguration
import com.ashok.demos.automation.annotation.WebdriverScopeBean
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import java.net.URL


@Profile("grid")
@LazyConfiguration
class RemoteWebDriverConfig {
    @Value("\${selenium.grid.url}")
    private val url: URL? = null
    @WebdriverScopeBean
    @ConditionalOnProperty(name = ["browser"], havingValue = "firefox")
    @Primary
    fun remoteFirefoxDriver(): WebDriver {
        val firefoxOptions = FirefoxOptions()
        return RemoteWebDriver(url, firefoxOptions)
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = ["browser"], havingValue = "edge")
    @Primary
    fun remoteEdgeDriver(): WebDriver {
        val edgeOptions = EdgeOptions()
        return RemoteWebDriver(url, edgeOptions)
    }

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = ["browser"], havingValue = "chrome")
    @Primary
    fun remoteChromeDriver(): WebDriver {
        val chromeOptions = ChromeOptions()
        return RemoteWebDriver(url, chromeOptions)
    }
}
