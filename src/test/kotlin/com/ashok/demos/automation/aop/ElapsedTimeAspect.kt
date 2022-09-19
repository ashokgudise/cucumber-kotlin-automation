package com.ashok.demos.automation.aop

import com.ashok.demos.automation.config.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.context.annotation.Configuration


@Aspect
@Configuration
class ElapsedTimeAspect {

    companion object: Log {}

    @Around(" @annotation(com.ashok.demos.automation.annotation.ElapsedTime)")
    @Throws(Throwable::class)
    fun around(proceedingJoinPoint: ProceedingJoinPoint): Any {
        val startTime = System.currentTimeMillis()
        val obj = proceedingJoinPoint.proceed()
        val duration = System.currentTimeMillis() - startTime

        logger().info(
            "Elapsed time of {} class's {} method is {}", proceedingJoinPoint
                .signature
                .declaringTypeName,
            proceedingJoinPoint
                .signature
                .name, "$duration ms."
        )
        return obj
    }
}
