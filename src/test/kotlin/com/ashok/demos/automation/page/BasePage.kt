package com.ashok.demos.automation.page

import com.ashok.demos.automation.utils.LogUtil
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct


abstract class BasePage {

    @Autowired
    protected lateinit var driver: WebDriver

    @Autowired
    protected lateinit var wait: WebDriverWait

    @Autowired
    protected lateinit var javascriptExecutor: JavascriptExecutor

    @Autowired
    protected lateinit var logUtil: LogUtil

    @PostConstruct
    private fun init() {
        PageFactory.initElements(driver, this)
    }

    abstract val isAt: Boolean

    fun  waitElement(elementAttr: By) =
            wait.until(ExpectedConditions.presenceOfElementLocated(elementAttr))

    fun <T> waitWebElement(elementAttr: T)
        = wait.until(ExpectedConditions.visibilityOf(elementAttr as WebElement))

    fun waitElements(elementAttr: By)
        = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementAttr))


    fun <T> waitWebElements(elementAttr: T)
        = wait.until(ExpectedConditions.visibilityOfAllElements(elementAttr as WebElement))

    fun <T> click(elementAttr: By) {
        waitElement(elementAttr)

            driver
                .findElement(elementAttr)
                .click()
           }

    fun <T> clickWebElement(elementAttr: T) {
        waitWebElement(elementAttr)
        (elementAttr as WebElement).click()
    }

    fun jsClick(by: By?) {
        javascriptExecutor.executeScript(
            "arguments[0].click();",
            wait.until(ExpectedConditions.visibilityOfElementLocated(by))
        )
    }


    fun  writeText(elementAttr: By, text: String?) {
        waitElement(elementAttr)

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementAttr))
            driver
                .findElement(elementAttr)
                .sendKeys(text)

    }

    fun <T> writeWebElementText(elementAttr: T, text: String?) {
        waitWebElement(elementAttr)

        (elementAttr as WebElement).sendKeys(text)
    }

    fun <T> readText(elementAttr: By): String
        = driver.findElement(elementAttr).text


    fun <T> readWebElementText(elementAttr: T): String {
        waitWebElement(elementAttr)
        return (elementAttr as WebElement).text
    }

    fun <T> readTextErrorMessage(elementAttr: T): String {
        Thread.sleep(2000) //This needs to be improved.
        return driver
            .findElement(elementAttr as By)
            .text
    }

    //Close popup if exists
    @Throws(InterruptedException::class)
    fun handlePopup(by: By) {
        waitElements(by)
        val popup = driver.findElements(by)
        if (popup.isNotEmpty()) {
            popup[0]
                .click()
            Thread.sleep(200)
        }
    }
}