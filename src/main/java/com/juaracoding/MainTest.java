package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;

public class MainTest {

    private static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();

        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        driver.get(url);

        // Call method from pages
        LoginPage loginPage = new LoginPage();

//        loginPage.performUserBlankLogin("", "");
//        DriverSingleton.delay(2);
//
//        loginPage.performUserInvalidLogin("Adminn", "admin123");
//        System.out.println(loginPage.getTxtInvalidLogin());

        loginPage.performUserLogin("Admin", "admin123");
        System.out.println(loginPage.getTxtDashboard());

        RecruitmentPage recruitmentPage = new RecruitmentPage();
        recruitmentPage.navigateToRecruitmentPage();
        recruitmentPage.performAddCandidate();
//        recruitmentPage.fillFirstName("Anggun");
//        recruitmentPage.fillMiddleName("Berlian");
//        recruitmentPage.fillLastName("Agustina");
//        recruitmentPage.selectVacancy();
//        recruitmentPage.fillEmailField("ikrarb95@gmail.com");
//        recruitmentPage.fillContactNumber("081393333818");
//        recruitmentPage.chooseResume("C:\\MyTools\\example.txt");
//        recruitmentPage.fillKeyword("Juara Coding");
//        recruitmentPage.chooseDateOfApplicant("2001-06-23");
//        recruitmentPage.fillNotes("Quality Control");
        recruitmentPage.checkBoxConsentData();
        System.out.println(recruitmentPage.isConsentDataChecked());
//        recruitmentPage.submitData();

        DriverSingleton.delay(3);
        loginPage.performUserLogout();

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();

    }

}
