package com.juaracoding;

import org.openqa.selenium.WebDriver;

import static com.juaracoding.ConnectBrowsers.setupChromeDriver;
import static com.juaracoding.SauceDemoTest.*;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        // Setup Chrome
        WebDriver chromeDriver = setupChromeDriver();
        performCheckUserLogin(chromeDriver);
        performUserShopping(chromeDriver);
        performUserLogout(chromeDriver);
        chromeDriver.quit();
    }
}
