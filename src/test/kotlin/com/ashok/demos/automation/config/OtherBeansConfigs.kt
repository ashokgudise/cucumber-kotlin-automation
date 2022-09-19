package com.ashok.demos.automation.config

import com.ashok.demos.automation.annotation.LazyConfiguration
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

@LazyConfiguration
class OtherBeansConfigs {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun javascriptExecutor(driver: WebDriver?): JavascriptExecutor? {
        return driver as JavascriptExecutor?
    }
}