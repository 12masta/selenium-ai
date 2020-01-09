package com.marcinstanek.seleniumjavaspockboilerplate.config

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import spock.lang.Specification

@Epic("Config")
@Feature("Config")
class ConfigSpec extends Specification {

    @Story("should import configuration")
    def 'should import configuration'() {
        given:
        def conf = new ConfigSlurper("dev")
                .parse(getClass().getResource("/config.groovy").toURI().toURL())
        expect:
        conf.url == 'http://localhost:4100/'
    }
}