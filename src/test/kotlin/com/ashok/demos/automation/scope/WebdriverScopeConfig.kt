package com.ashok.demos.automation.scope

import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class WebdriverScopeConfig {
    @Bean
    fun beanFactoryPostProcessor(): BeanFactoryPostProcessor {
        return WebdriverScopePostProcessor()
    }
}