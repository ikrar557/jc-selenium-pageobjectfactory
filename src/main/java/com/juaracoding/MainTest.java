package com.juaracoding;

import org.openqa.selenium.WebDriver;

import static com.juaracoding.ConnectBrowsers.setupChromeDriver;
import static com.juaracoding.SauceDemoTest.performAddProduct;
import static com.juaracoding.SauceDemoTest.performCheckUserLogin;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        // Setup Chrome
        WebDriver chromeDriver = setupChromeDriver();
        performCheckUserLogin(chromeDriver);
        performAddProduct(chromeDriver);
        chromeDriver.quit();
    }
}
