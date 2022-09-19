package com.ashok.demos.automation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CucumberKotlinAutomationApplication

fun main(args: Array<String>) {
    runApplication<CucumberKotlinAutomationApplication>(*args)
}
