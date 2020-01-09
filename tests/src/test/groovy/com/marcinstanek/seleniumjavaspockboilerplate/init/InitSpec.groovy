package com.marcinstanek.seleniumjavaspockboilerplate.init

import com.marcinstanek.seleniumjavaspockboilerplate.BaseSpec
import io.qameta.allure.Epic
import io.qameta.allure.Feature

@Epic("InitSpec")
@Feature("InitSpec")
class InitSpec extends BaseSpec {
    def 'first specifiacation'(){
        expect:
        driver.currentUrl == 'http://localhost:4100/'
    }
}
