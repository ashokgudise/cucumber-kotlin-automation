package com.ashok.demos.automation.utils

import com.ashok.demos.automation.annotation.LazyComponent
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.CapabilityType
import java.util.logging.Level


@LazyComponent
class BrowserOps {

    val getChromeOptions: ChromeOptions
    get(){
        val chromeOptions = ChromeOptions()
        val logPrefs = LoggingPreferences()
        logPrefs.enable(LogType.BROWSER, Level.ALL)
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs)
        return chromeOptions
    }

    val getFireFoxOptions: FirefoxOptions
    get(){
        val firefoxProfile = FirefoxProfile()
        firefoxProfile.setPreference("devtools.console.stdout.content", true)
        val firefoxOptions = FirefoxOptions()
        val logPrefs = LoggingPreferences()
        logPrefs.enable(LogType.BROWSER, Level.ALL)
        logPrefs.enable(LogType.DRIVER, Level.ALL)
        firefoxOptions
            .setProfile(firefoxProfile)
            .setCapability(CapabilityType.LOGGING_PREFS, logPrefs)
        return firefoxOptions
    }
}