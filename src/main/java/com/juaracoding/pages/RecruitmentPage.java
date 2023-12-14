package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.security.cert.X509Certificate;

import static com.juaracoding.drivers.DriverSingleton.delay;

public class RecruitmentPage {
    private WebDriver driver;

    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Recruitment']")
    private WebElement recruitmentButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addCandidate;

    // Start of element to fill the field
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    public WebElement vacancySelect;

    @FindBy(xpath = "//div[3]/div/div/div/div[2]/input")
    private WebElement emailField;

    @FindBy(xpath = "//div[3]/div/div[2]/div/div[2]/input")
    private WebElement contactNumberField;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resumeUploadField;

    @FindBy(xpath = "//div[@id='app']/div/div[2]/div[2]/div/div/form/div[5]/div/div/div/div[2]/input")
    private WebElement keywordField;
    
    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    private WebElement dateOfApplication;

    @FindBy(xpath = "//div[@id='app']/div/div[2]/div[2]/div/div/form/div[6]/div/div/div/div[2]/textarea")
    private WebElement notesField;

    @FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    private WebElement consentData;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[1]/p")
    private WebElement successSubmitCandidate;

    public void navigateToRecruitmentPage(){
        recruitmentButton.click();
    }

    public void performAddCandidate(){
        addCandidate.click();
    }

    public void fillFirstName(String firstName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void fillMiddleName(String middleName){
        this.middleName.clear();
        this.middleName.sendKeys(middleName);
    }

    public void fillLastName(String lastName){
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void selectVacancy() {
        vacancySelect.click();
        delay(2);
        int arrowDownCount = 7;
        for (int i = 0; i < arrowDownCount; i++) {
            vacancySelect.sendKeys(Keys.ARROW_DOWN);
        }

        vacancySelect.sendKeys(Keys.ENTER);

    }
    public void fillEmailField(String email){
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void fillContactNumber(String contactNumber){
        this.contactNumberField.clear();
        this.contactNumberField.sendKeys(contactNumber);
    }

    public void chooseResume(String filePath) {
        resumeUploadField.sendKeys(filePath);
    }
    public void fillKeyword(String keyword){
        this.keywordField.clear();
        this.keywordField.sendKeys(keyword);
    }

    public void chooseDateOfApplicant(String date) {
        dateOfApplication.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dateOfApplication.sendKeys(Keys.DELETE);
        dateOfApplication.sendKeys(date);
    }
    public void fillNotes(String notes){
        this.notesField.clear();
        this.notesField.sendKeys(notes);
    }

    public void checkBoxConsentData(){
        consentData.click();
    }

    public void submitData(){
        submitButton.click();
    }

    public String getFirstNameValue(){
        return firstName.getAttribute("value");
    }

    public String getMiddleNameValue(){
        return middleName.getAttribute("value");
    }

    public String getLastNameValue(){
        return lastName.getAttribute("value");
    }

    public String getVacancySelectValue(){
        return vacancySelect.getText();
    }

    public String getEmailValue(){
        return emailField.getAttribute("value");
    }

    public String getContactNumberValue(){
        return contactNumberField.getAttribute("value");
    }

    public String getResumeUploadValue(){
        return resumeUploadField.getAttribute("value");

    }

    public String getKeywordValue(){
        return keywordField.getAttribute("value");
    }

    public String getDateOfApplicationValue(){
        return dateOfApplication.getAttribute("value");
    }

    public String getNotesValue(){
        return notesField.getAttribute("value");
    }

    // TODO: Create get value if the consent data is ticked
    public boolean isConsentDataChecked() {
        String selector = ".oxd-checkbox-wrapper label input[type=checkbox]:checked+.oxd-checkbox-input[data-v-6179b72a]";
        return driver.findElement(By.cssSelector(selector)).isDisplayed();
    }

    public String getSuccessAddCandidateValue() {
        return successSubmitCandidate.getText();
    }
}
