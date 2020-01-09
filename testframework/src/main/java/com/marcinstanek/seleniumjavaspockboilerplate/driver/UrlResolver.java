package com.marcinstanek.seleniumjavaspockboilerplate.driver;

public interface UrlResolver {
    void goToRelativeUrl(String relativeUrl);

    public String getUrlRelativePath();

    public String getUrl();
}
