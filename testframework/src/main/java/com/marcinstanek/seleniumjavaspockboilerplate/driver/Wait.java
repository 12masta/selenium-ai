package com.marcinstanek.seleniumjavaspockboilerplate.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {
    private WebDriverWait wait;

    public Wait(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
    }

    public void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void elementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void visibilityOf(WebElement taskFormContainer) {
        wait.until(ExpectedConditions.visibilityOf(taskFormContainer));
    }

    public void seconds(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waintUntilElementByCountIsGreaterThenNumber(WebElement element, By by, int numberOfElements) {
        wait.until((ExpectedCondition<Boolean>) driver -> element.findElements(by).size() > numberOfElements);
    }

    public void invisibilityOf(WebElement taskFormContainer) {
        wait.until(ExpectedConditions.invisibilityOf(taskFormContainer));
    }

    public void elementsToBeClickable(WebElement element, By by) {
        List<WebElement> elements = element.findElements(by);
        elements.forEach(this::elementToBeClickable);
    }

    public void waitUntilPageIsFullyLoaded() {
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
