package com.ashok.demos.automation.annotation

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@org.springframework.context.annotation.Lazy
@Component
@MustBeDocumented
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class LazyComponent
