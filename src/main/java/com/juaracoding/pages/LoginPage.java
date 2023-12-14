package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    // Start of locator elements for performUserLogin
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button')]")
    private WebElement btnLogin;
    @FindBy(xpath = "//h6[contains(@class, 'topbar-header')]")
    private WebElement txtDashboard;

    // Start of locator elements for performUserLogout
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement buttonLogout;

    // Start of locator elements for return performUserInvalidLogin
    @FindBy(xpath = "//p[contains(@class, 'alert-content-text')]")
    private WebElement txtInvalidLogin;

    // Start of locator element for return getTextBlankLogin
    @FindBy(xpath = "//form[@class='oxd-form']/div[1]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement txtBlankLogin;

    public void performUserBlankLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }
    public void performUserInvalidLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void performUserLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void performUserLogout(){
        profileButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        buttonLogout.click();
    }


    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalidLogin(){
        return txtInvalidLogin.getText();
    }

    public String getTxtRequired(){
        return txtBlankLogin.getText();
    }
}
