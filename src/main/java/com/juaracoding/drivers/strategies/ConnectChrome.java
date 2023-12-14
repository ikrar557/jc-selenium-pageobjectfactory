package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConnectChrome implements DriverStrategy {
    @Override
    public WebDriver setStrategy(){
        String chromePathDriver = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePathDriver);

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments("--no-sandbox");
        return new ChromeDriver(chromeOptions);
    };
}
