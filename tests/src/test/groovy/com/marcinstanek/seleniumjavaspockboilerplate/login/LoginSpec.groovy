package com.marcinstanek.seleniumjavaspockboilerplate.login

import com.marcinstanek.seleniumjavaspockboilerplate.BaseSpec
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import org.openqa.selenium.By

@Epic("LoginSpec")
@Feature("LoginSpec")
class LoginSpec extends BaseSpec {
    def 'Open login page from home page'(){
        when: 'user click Sign in button'
        def elements = classifier.findElementsMatchingLabel(driver, "Sign in")
        elements.first().click()

        then: 'is redirected to /login'
        driver.currentUrl == 'http://localhost:4100/login'
    }

    def 'User click settings link at home page'(){
        given: 'user is on the login page'
        driver.get(getConfig().url + 'login')

        when: 'email field has been filled'
        driver.findElement(By.xpath("//*[@data-cy='email-input']"))
                .sendKeys('marcin@marcin.pl')
        and: 'password field has been filled'
        driver.findElement(By.xpath("//*[@data-cy='password-input']"))
                .sendKeys('marcin')
        and: 'button clicked'
        driver.findElement(By.xpath("//*[@data-cy='button-input']"))
                .click()
        and: 'settings link clicked'
        def button = classifier.findElementsMatchingLabel(driver, "settings")
        button.first().click()

        then: 'user should be redirected to /settings'
        driver.currentUrl == 'http://localhost:4100/settings'
    }
}
