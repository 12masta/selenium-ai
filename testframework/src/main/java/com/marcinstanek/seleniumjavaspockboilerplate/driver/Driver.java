package com.marcinstanek.seleniumjavaspockboilerplate.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver driver;
    private int implicitWaitOnSeconds;

    public WebDriver initialize(String browser, int implicitWaitOnSeconds) {
        this.implicitWaitOnSeconds = implicitWaitOnSeconds;

        if (browser.equalsIgnoreCase("Chrome")) {
            return getChromeDriver();
        }
        if (browser.equalsIgnoreCase("InternetExplorer")) {
            return getInternetExplorerDriver();
        }
        if (browser.equalsIgnoreCase("Firefox")) {
            return getFirefoxDriver();
        } else {
            return getChromeDriver();
        }
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        manageDriverSettings(driver, implicitWaitOnSeconds);
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        manageDriverSettings(driver, implicitWaitOnSeconds);
        return driver;
    }

    private WebDriver getInternetExplorerDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.ignoreZoomSettings();
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(options);
        manageDriverSettings(driver, implicitWaitOnSeconds);
        return driver;
    }

    private void manageDriverSettings(WebDriver driver, int implicitWaitOnSeconds) {
        driver.manage().timeouts().implicitlyWait(implicitWaitOnSeconds, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }
}
