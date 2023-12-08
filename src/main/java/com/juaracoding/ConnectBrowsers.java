package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ConnectBrowsers {

    public static WebDriver setupChromeDriver() {

        String chromePathDriver = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePathDriver);

        ChromeOptions chromeOptions = new ChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

}
