package com.ashok.demos.automation.utils

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import java.util.*


//Custom Expected Condition Class
class ElementContainsText     //Constructor (Set the given values)
    (private val by: By, private val textToFind: String) : ExpectedCondition<Boolean?> {
    //Override the apply method with your own functionality
    override fun apply(webDriver: WebDriver?): Boolean? {
        //Find the element with given By method (By CSS, XPath, Name, etc.)
        val element = Objects
            .requireNonNull(webDriver)
            ?.findElement(by)

        //Check that the element contains given text?
        return element
            ?.text
            ?.contains(textToFind)
    }

    //This is for log message. I override it because when test fails, it will give us a meaningful message.
    override fun toString(): String {
        return ": \"Does " + by + " contain " + textToFind + "?\""
    }
}
