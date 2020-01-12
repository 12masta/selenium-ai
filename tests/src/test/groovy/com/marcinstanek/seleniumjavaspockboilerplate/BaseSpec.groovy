package com.marcinstanek.seleniumjavaspockboilerplate

import ai.test.classifier_client.ClassifierClient
import com.anotherchrisberry.spock.extensions.retry.RetryOnFailure
import com.marcinstanek.seleniumjavaspockboilerplate.config.ScreenshotOnFailureListener
import com.marcinstanek.seleniumjavaspockboilerplate.driver.Driver
import com.marcinstanek.seleniumjavaspockboilerplate.pageobjects.BasePage
import com.marcinstanek.seleniumjavaspockboilerplate.pageobjects.BasePageImpl
import org.openqa.selenium.WebDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

@RetryOnFailure(times = 1)
class BaseSpec extends Specification {
    public static String env = System.getProperty('env', 'dev')
    public static String browser = System.getProperty('browser', 'chrome')
    private static Logger logger = LoggerFactory.getLogger(BaseSpec.class)
    protected WebDriver driver
    protected BasePage basePage
    protected ClassifierClient classifier;

    def setup() {
        setupDriver()
        setupClassifier()
        getScreenshotListener().driver = driver
        basePage = new BasePageImpl(driver)
    }

    def cleanup() {
        driver.quit()
        if (classifier != null) {
            classifier.shutdown()
        }
    }

    def setupDriver() {
        driver = new Driver().initialize(browser, 10)
        driver.get(getConfig().url)
    }

    def setupClassifier(){
        classifier = new ClassifierClient("127.0.0.1", 50051);
    }

    def getScreenshotListener() {
        this.specificationContext.currentSpec.listeners.find { it instanceof ScreenshotOnFailureListener }
    }

    def getConfig() {
        def config = new ConfigSlurper(env).parse(getClass().getResource("/config.groovy").toURI().toURL())
        logger.info("URL: " + config.url)
        config
    }
}
