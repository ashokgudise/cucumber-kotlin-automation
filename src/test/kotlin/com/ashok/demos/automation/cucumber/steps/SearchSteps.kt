package com.ashok.demos.automation.cucumber.steps

import com.ashok.demos.automation.annotation.LazyAutowired
import com.ashok.demos.automation.page.SearchPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.springframework.beans.factory.annotation.Value


class SearchSteps {

    @Value("\${browser}")
    private val browser: String? = null

    @LazyAutowired
    private val searchPage: SearchPage? = null

    @Given("open chrome browser and click on search")
    fun openChromeBrowser(){
        searchPage?.goToChromeBrowser()
    }

    @When("search for my name {string}")
    fun searchForMyName(name: String){
        searchPage?.searchForMyName(name)
    }

    @Then("verify the name appears from my LinkedIn Profile")
    fun verifyMyNameFromLinkedIn(){
        searchPage?.verifyMyNameInSearchResults()
    }

}