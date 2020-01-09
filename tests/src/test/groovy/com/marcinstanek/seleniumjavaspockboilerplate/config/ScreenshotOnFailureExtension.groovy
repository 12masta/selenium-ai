package com.marcinstanek.seleniumjavaspockboilerplate.config

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class ScreenshotOnFailureExtension implements IGlobalExtension {

    @Override
    void start() {
    }

    @Override
    void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new ScreenshotOnFailureListener())
    }

    @Override
    void stop() {
    }
}
