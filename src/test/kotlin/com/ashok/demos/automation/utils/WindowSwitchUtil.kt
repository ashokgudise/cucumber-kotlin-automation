package com.ashok.demos.automation.utils

import com.ashok.demos.automation.annotation.LazyComponent
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext


@LazyComponent
class WindowSwitchUtil {

    @Autowired
    private lateinit var ctx: ApplicationContext

    fun switchByWindowTitle(title: String?) {
        val driver = ctx.getBean(WebDriver::class.java)
        driver
            .windowHandles
            .stream()
            .map { handle: String? ->
                driver
                    .switchTo()
                    .window(handle)
                    .title
            }
            .filter { t: String -> t.startsWith(title!!) }
            .findFirst()
            .orElseThrow<RuntimeException> { throw RuntimeException("There is no such window available.") }
    }

    fun switchByIndex(index: Int) {
        val driver = ctx.getBean(WebDriver::class.java)
        val handles = driver
            .windowHandles
            .toTypedArray()
        driver
            .switchTo()
            .window(handles[index])
    }
}