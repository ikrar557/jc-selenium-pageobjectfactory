package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SauceDemoTest {
    static String sauceDemoUrl = "https://www.saucedemo.com";
    static String firstName = "Ikrar";
    static String lastName = "Bagaskara";
    static String postalCode = "57474";

    public static void openBrowser(WebDriver driver) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(sauceDemoUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Opening Browser");
    }

    public static void homepageValidation(WebDriver driver) throws InterruptedException {
        WebElement productsTextElement = driver.findElement(By.xpath("//span[contains(.,'Products')]"));
        String productsText = productsTextElement.getText();
        if(productsText.equals("Products")){
            System.out.println("Passes : Navigate to homepage");
        } else {
            System.out.println("Failed : Navigate to homepage");
        }
    }

    public static void performCheckUserLogin(WebDriver driver) throws InterruptedException {
        String username = "standard_user";
        String failedUsername = "standart_user";
        String password = "secret_sauce";

        openBrowser(driver);

        WebElement usernameInput = driver.findElement(By.name("user-name"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.name("login-button"));

        //      Test Case Negative Failed Login
        Thread.sleep(1000);
        usernameInput.sendKeys(failedUsername);

        Thread.sleep(1000);
        passwordInput.sendKeys(password);

        Thread.sleep(1000);
        submitButton.click();

        //      Validation Failed Login
        WebElement errorLoginElement = driver.findElement(By.xpath("//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]"));
        String errorLoginText = errorLoginElement.getText();
        if(errorLoginText.equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Passes : Wrong Credentials");
        } else {
            System.out.println("Failed : User still able to login");
        }

        //      Test Case Positive Login
        usernameInput.clear();
        Thread.sleep(1000);
        usernameInput.sendKeys(username);

        passwordInput.clear();
        Thread.sleep(1000);
        passwordInput.sendKeys(password);

        Thread.sleep(1000);
        submitButton.click();

        Thread.sleep(2000);

        //      Validation Positive Login
        homepageValidation(driver);
    }

    public static void performUserLogout(WebDriver driver) throws InterruptedException {
        WebElement sideBar = driver.findElement(By.id("react-burger-menu-btn"));
        // Test Case Positive Logout
        Thread.sleep(1000);
        sideBar.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));

        Thread.sleep(1000);
        logoutButton.click();

        Thread.sleep(3000);

        //  Validation Logout Action
        By usernameInput = By.name("user-name");

        if (!driver.findElements(usernameInput).isEmpty()) {
            System.out.println("Passes : Back to login page");
        } else {
            System.out.println("Failed : Error");
        }

        System.out.println("Closing the browser");
    }

    public static void performUserAddProduct(WebDriver driver) throws  InterruptedException {

        WebElement addProductSauceBackpack = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        WebElement shoppingCartLink = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a"));
        //      Test Case Positive Add Product
        Thread.sleep(1000);
        addProductSauceBackpack.click();

        Thread.sleep(1000);
        shoppingCartLink.click();

        //      Validation Add Product
        WebElement backpackElement = driver.findElement(By.xpath("//a[@id='item_4_title_link']/div"));
        String backpackElementText = backpackElement.getText();
        if(backpackElementText.equals("Sauce Labs Backpack")){
            System.out.println("Passes : Add the Sauce Labs Backpack");
        } else {
            System.out.println("Failed : Add the Sauce Labs Backpack");
        }

    }
    public static void performUserCheckout(WebDriver driver) throws InterruptedException {

        WebElement checkout = driver.findElement(By.name("checkout"));

        Thread.sleep(1000);
        checkout.click();

        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        WebElement postcalCodeInput = driver.findElement(By.name("postalCode"));
        //      Test Case Add Information
        Thread.sleep(1000);
        firstNameInput.sendKeys(firstName);

        Thread.sleep(1000);
        lastNameInput.sendKeys(lastName);

        Thread.sleep(1000);
        postcalCodeInput.sendKeys(postalCode);

        WebElement continueCheckout = driver.findElement(By.name("continue"));

        Thread.sleep(1000);;
        continueCheckout.click();

        //      Validation Add User Information
        By checkoutSummaryXPath = By.xpath("//div[@id='checkout_summary_container']/div/div[2]/div");

        if (!driver.findElements(checkoutSummaryXPath).isEmpty()) {
            System.out.println("Passes : Add user information");
        } else {
            System.out.println("Failed : Add user information");
        }

        //      Finish shopping/checkout
        WebElement finishCheckout = driver.findElement(By.name("finish"));

        Thread.sleep(1000);
        finishCheckout.click();

        System.out.println("Finishing Checkout");

        //      Back to Homepage
        WebElement backToHomePage = driver.findElement(By.name("back-to-products"));

        Thread.sleep(1000);
        backToHomePage.click();

        //      Validation Back to HomePage
        homepageValidation(driver);

        Thread.sleep(2000);
    }
}
