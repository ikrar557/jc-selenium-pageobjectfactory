package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SauceDemoTest {
    static String sauceDemoUrl = "https://www.saucedemo.com";

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
        String password = "secret_sauce";

        openBrowser(driver);
        //      Test Case Positive Login
        WebElement usernameInput = driver.findElement(By.name("user-name"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.name("login-button"));

        Thread.sleep(1000);
        usernameInput.sendKeys(username);

        Thread.sleep(1000);
        passwordInput.sendKeys(password);

        Thread.sleep(1000);
        submitButton.click();

        Thread.sleep(2000);

        // Validation Login
        homepageValidation(driver);

    }

    public static void performAddProduct(WebDriver driver) throws InterruptedException {
        String firstName = "Ikrar";
        String lastName = "Bagaskara";
        String postalCode = "57474";

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
            System.out.println("Passes : Add the product");
        } else {
            System.out.println("Failed : Add the product");
        }

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

        Thread.sleep(3000);
        System.out.println("Closing the browser");


    }
}
