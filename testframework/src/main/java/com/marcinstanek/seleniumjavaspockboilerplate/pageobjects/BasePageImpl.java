package com.marcinstanek.seleniumjavaspockboilerplate.pageobjects;

import com.marcinstanek.seleniumjavaspockboilerplate.driver.UrlResolver;
import com.marcinstanek.seleniumjavaspockboilerplate.driver.UrlResolverImpl;
import com.marcinstanek.seleniumjavaspockboilerplate.driver.Wait;
import com.marcinstanek.seleniumjavaspockboilerplate.handlers.WebElementsHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageImpl extends PageObject implements BasePage {

    @FindBy(id = "search")
    private WebElement search;

    @FindBy(xpath = "//ul[@class='sug']")
    private WebElement sug;

    protected WebElementsHandler webElementsHandler;
    protected Wait wait;
    protected UrlResolver urlResolver;

    public BasePageImpl(WebDriver driver) {
        super(driver);
        webElementsHandler = new WebElementsHandler(driver);
        wait = new Wait(driver);
        urlResolver = new UrlResolverImpl(driver);
        wait.waitUntilPageIsFullyLoaded();
    }

    @Override
    public String getUrl() {
        return urlResolver.getUrl();
    }
}
