package com.ashok.demos.automation.scope

import org.openqa.selenium.remote.RemoteWebDriver
import org.springframework.beans.factory.ObjectFactory
import org.springframework.context.support.SimpleThreadScope
import java.util.*


class WebdriverScope : SimpleThreadScope() {
    override operator fun get(name: String, objectFactory: ObjectFactory<*>): Any {
        var o = super.get(name, objectFactory)
        val sessionId = (o as RemoteWebDriver).sessionId
        if (Objects.isNull(sessionId)) {
            super.remove(name)
            o = super.get(name, objectFactory)
        }
        return o
    }

    override fun registerDestructionCallback(name: String, callback: Runnable) {}
}
