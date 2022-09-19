package com.ashok.demos.automation.annotation

import org.springframework.context.annotation.Configuration

@MustBeDocumented
@org.springframework.context.annotation.Lazy
@Configuration
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class LazyConfiguration
