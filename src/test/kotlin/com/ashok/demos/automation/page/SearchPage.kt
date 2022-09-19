package com.ashok.demos.automation.page

import com.ashok.demos.automation.annotation.LazyComponent
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.springframework.beans.factory.annotation.Value

@LazyComponent
class SearchPage : BasePage() {

    @Value("\${search-flow.url}")
    private val baseURL: String? = null

    @FindBy(how = How.XPATH, using = "//input[@name='btnK']")
    var searchButton: WebElement? = null
    @FindBy(how = How.ID_OR_NAME, using = "q")
    var searchInput: WebElement? = null

    var myNameFromLinkedIn = By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3")

    override val isAt: Boolean
        get() = wait.until { d -> searchButton!!.isDisplayed}

    fun goToChromeBrowser(): SearchPage{
        driver[baseURL]
        return this
    }

    fun searchForMyName(name: String): SearchPage{
        writeWebElementText(searchInput, name)
        clickWebElement(searchButton)
        return this
    }

    fun verifyMyNameInSearchResults(): SearchPage {
        waitElements(myNameFromLinkedIn)
        Assertions.assertTrue(driver.findElement(myNameFromLinkedIn).isDisplayed)
        return this
    }
}