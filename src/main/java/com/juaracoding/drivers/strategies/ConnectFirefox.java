package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ConnectFirefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy(){
        String firefoxPathDriver = "C:\\MyTools\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxPathDriver);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    };
}
