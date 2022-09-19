package com.ashok.demos.automation.config

import org.slf4j.LoggerFactory

interface Log {

    fun logger() = LoggerFactory.getLogger(this.javaClass)

}