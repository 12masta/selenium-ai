package com.marcinstanek.seleniumjavaspockboilerplate.driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static java.lang.System.out;

public class UrlResolverImpl implements UrlResolver {
    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger(UrlResolverImpl.class);

    public UrlResolverImpl(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRelativeUrl(String relativeUrl) {
        try {
            driver.get(new URI(driver.getCurrentUrl()).resolve(relativeUrl).toString());
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getUrlRelativePath() {
        String currentUrl = getUrl();
        String relativePath = currentUrl.substring(currentUrl.indexOf(".com/") + 4, currentUrl.length());
        out.println("URL relative path: " + relativePath);
        System.out.println("Relative URL: " + relativePath);
        return relativePath;
    }

    public String getUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}
