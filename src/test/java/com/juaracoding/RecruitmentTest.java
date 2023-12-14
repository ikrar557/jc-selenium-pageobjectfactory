package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.juaracoding.drivers.DriverSingleton.delay;

public class RecruitmentTest {
    private WebDriver driver;

    private RecruitmentPage recruitmentPage;

    @BeforeClass
    public void setUp(){
        recruitmentPage = new RecruitmentPage();
        recruitmentPage.navigateToRecruitmentPage();
        recruitmentPage.performAddCandidate();
    }

    @Test(priority = 1)
    public void testInputFirstName(){
        recruitmentPage.fillFirstName("Anggun");
        Assert.assertEquals(recruitmentPage.getFirstNameValue(), "Anggun");
    }

    @Test(priority = 2)
    public void testInputMiddleName(){
        recruitmentPage.fillMiddleName("Berlian");
        Assert.assertEquals(recruitmentPage.getMiddleNameValue(), "Berlian");
    }

    @Test(priority = 3)
    public void testInputLastName(){
        recruitmentPage.fillLastName("Agustina");
        Assert.assertEquals(recruitmentPage.getLastNameValue(), "Agustina");
    }

    @Test(priority = 4)
    public void testInputVacancy(){
        recruitmentPage.vacancySelect.click();
        delay(2);
        int arrowDownCount = 7;
        for (int i = 0; i < arrowDownCount; i++) {
            recruitmentPage.vacancySelect.sendKeys(Keys.ARROW_DOWN);
        }

        recruitmentPage.vacancySelect.sendKeys(Keys.ENTER);
        Assert.assertEquals(recruitmentPage.getVacancySelectValue(), "Software Engineer");
    }

    @Test(priority = 5)
    public void testInputEmail(){
        recruitmentPage.fillEmailField("ikrarb95@gmail.com");
        Assert.assertEquals(recruitmentPage.getEmailValue(), "ikrarb95@gmail.com");
    }

    @Test(priority = 6)
    public void testInputContactNumber(){
        recruitmentPage.fillContactNumber("081393333838");
        Assert.assertEquals(recruitmentPage.getContactNumberValue(), "081393333838");
    }

    @Test(priority = 7)
    public void testInputResume(){
        recruitmentPage.chooseResume("C:\\MyTools\\example.txt");
        Assert.assertEquals(recruitmentPage.getResumeUploadValue(), "C:\\fakepath\\example.txt");
    }

    @Test(priority = 8)
    public void testInputKeyword(){
        recruitmentPage.fillKeyword("Quality Assurance");
        Assert.assertEquals(recruitmentPage.getKeywordValue(), "Quality Assurance");
    }

    @Test(priority = 9)
    public void testDateOfApplication(){
        recruitmentPage.chooseDateOfApplicant("2001-06-23");
        Assert.assertEquals(recruitmentPage.getDateOfApplicationValue(), "2001-06-23");
    }

    @Test(priority = 10)
    public void testInputNotes(){
        recruitmentPage.fillNotes("Juara Coding");
        Assert.assertEquals(recruitmentPage.getNotesValue(), "Juara Coding");
    }

    // TODO: Add test to check whether the consent data already ticked

    @Test(priority = 11)
    public void testCheckBoxConsentData(){
        recruitmentPage.checkBoxConsentData();
        Assert.assertTrue(recruitmentPage.isConsentDataChecked(), "Consent data checkbox should be checked");
    }

    @Test (priority = 12)
    public void submitCandidateForm(){
        recruitmentPage.submitData();
        Assert.assertEquals(recruitmentPage.getSuccessAddCandidateValue(), "Status: Application Initiated");
    }

}
