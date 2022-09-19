package com.ashok.demos.automation.annotation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

@Bean
@Scope("webdriverscope")
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class WebdriverScopeBean
