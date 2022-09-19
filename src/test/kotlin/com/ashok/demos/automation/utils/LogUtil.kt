package com.ashok.demos.automation.utils

import com.ashok.demos.automation.annotation.LazyComponent
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebDriver
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.openqa.selenium.logging.LogType


@LazyComponent
class LogUtil {

    companion object{
        fun getLogs(driver: WebDriver): LogEntries? {
            return driver
                .manage()
                .logs()[LogType.BROWSER]
        }
    }

    fun isLoginErrorLog(driver: WebDriver) {
        //Check logs (works only Chrome and Edge)
        val logEntries = driver
            .manage()
            .logs()[LogType.BROWSER]

        Assertions.assertTrue(logEntries
            .all
            .stream()
            .anyMatch { logEntry: LogEntry ->
                logEntry
                    .message
                    .contains("An invalid email address was specified")
            })
    }
}