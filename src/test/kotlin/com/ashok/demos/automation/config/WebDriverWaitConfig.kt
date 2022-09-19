package com.ashok.demos.automation.config

import com.ashok.demos.automation.annotation.LazyComponent
import com.ashok.demos.automation.annotation.LazyConfiguration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.Scope
import java.time.Duration

@LazyConfiguration
class WebDriverWaitConfig {
    @Value("\${default.timeout:30}")
    private val timeout = 0
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun webdriverWait(driver: WebDriver?): WebDriverWait {
        return WebDriverWait(driver, Duration.ofMillis(timeout.toLong()))
    }
}
