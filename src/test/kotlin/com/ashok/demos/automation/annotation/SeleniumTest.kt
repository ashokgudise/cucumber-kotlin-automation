package com.ashok.demos.automation.annotation

import com.ashok.demos.automation.CucumberKotlinAutomationApplication
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [CucumberKotlinAutomationApplication::class])
annotation class SeleniumTest
