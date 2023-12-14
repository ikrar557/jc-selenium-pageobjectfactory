package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.strategies.ConnectChrome;
import com.juaracoding.drivers.strategies.ConnectFirefox;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();

        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        driver.get(url);

        loginPage = new LoginPage();
    }

    @AfterSuite
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testBlankLogin(){
        loginPage.performUserLogin("", "");
        Assert.assertTrue(loginPage.getTxtRequired().contains("Required"));
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.performUserLogin("AAdmin", "admin1234");
        Assert.assertTrue(loginPage.getTxtInvalidLogin().contains("Invalid"));
    }

    @Test(priority = 3)
    public void testValidLogin(){
        loginPage.performUserLogin("Admin", "admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
    }

}
