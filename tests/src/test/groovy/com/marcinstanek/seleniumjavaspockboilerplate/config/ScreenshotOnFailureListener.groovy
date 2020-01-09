package com.marcinstanek.seleniumjavaspockboilerplate.config

import com.marcinstanek.seleniumjavaspockboilerplate.driver.ScreenshotManager
import org.openqa.selenium.WebDriver
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo

class ScreenshotOnFailureListener extends AbstractRunListener {
    WebDriver driver

    void error(ErrorInfo error) {
        def screenshot = new ScreenshotManager(driver)
        screenshot.takeScreenshot(message(error.method.parent.filename), message(error.method.name))
    }

    static def message(String text) {
        if (text == null) {
            "missing name"
        }
    }
}