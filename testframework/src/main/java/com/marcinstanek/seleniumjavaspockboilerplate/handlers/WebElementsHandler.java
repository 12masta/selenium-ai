package com.marcinstanek.seleniumjavaspockboilerplate.handlers;

import com.marcinstanek.seleniumjavaspockboilerplate.driver.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class WebElementsHandler {

    private WebDriver driver;
    private Wait wait;

    private static Logger logger = LoggerFactory.getLogger(WebElementsHandler.class);

    public WebElementsHandler(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public WebElementsHandler typeInputText(String input, By locator) {
        WebElement inputField = driver.findElement(locator);
        return typeInputText(input, inputField);
    }

    public WebElementsHandler typeInputText(String input, WebElement field) {
        click(field);
        field.clear();
        field.sendKeys(input);
        return this;
    }

    public WebElementsHandler click(WebElement field) {
        wait.elementToBeClickable(field);
        field.click();
        return this;
    }

    public WebElementsHandler click(By by) {
        WebElement element = driver.findElement(by);
        wait.elementToBeClickable(element);
        element.click();
        return this;
    }


    public boolean isDisplayed(WebElement element) {
        boolean isDisplayed;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            isDisplayed = false;
        }
        return isDisplayed;
    }


    public WebElement getDisplayedElement(List<WebElement> webElements) {
        Optional<WebElement> optionalWebElement = webElements.stream()
                .filter(webElement -> webElement.isDisplayed())
                .findFirst();
        if (optionalWebElement.isPresent()) {
            return optionalWebElement.get();
        } else {
            String errorMsg = "Button is not displayed";
            logger.error(errorMsg);
            throw new RuntimeException(errorMsg);
        }
    }
}