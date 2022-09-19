package com.ashok.demos.automation.aop

import com.ashok.demos.automation.annotation.TakeScreenshot
import com.ashok.demos.automation.utils.ScreenshotUtil
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.IOException


@Aspect
@Component
class ScreenshotAspect {

    @Autowired
    private lateinit var screenshotUtil: ScreenshotUtil

    @After("@annotation(takeScreenshot)")
    @Throws(IOException::class)
    fun after(joinPoint: JoinPoint, takeScreenshot: TakeScreenshot?) {
        screenshotUtil.takeScreenShot(joinPoint.signature.name)
    }
}
