package com.ashok.demos.automation.utils

import com.ashok.demos.automation.annotation.LazyComponent
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.util.FileCopyUtils
import java.io.IOException
import java.nio.file.Path


@LazyComponent
class ScreenshotUtil {

    @Autowired
    private lateinit var ctx: ApplicationContext

    @Value("\${application.screenshot.path}")
    private val path: Path? = null

    @Throws(IOException::class)
    fun takeScreenShot(testName: String) {
        val sourceFile = ctx.getBean(TakesScreenshot::class.java).getScreenshotAs(OutputType.FILE)
        FileCopyUtils.copy(sourceFile, path!!.resolve("$testName.png").toFile())
    }

    fun getScreenshot(): ByteArray? {
        return ctx.getBean(TakesScreenshot::class.java).getScreenshotAs(OutputType.BYTES)
    }
}