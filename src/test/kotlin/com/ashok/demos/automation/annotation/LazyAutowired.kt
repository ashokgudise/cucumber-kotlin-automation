package com.ashok.demos.automation.annotation

import org.springframework.beans.factory.annotation.Autowired

@org.springframework.context.annotation.Lazy
@Autowired
@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class LazyAutowired
