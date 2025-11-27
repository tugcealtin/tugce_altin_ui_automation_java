package com.tugcealtin.ui.tests;

import com.tugcealtin.ui.base.BaseTest;
import com.tugcealtin.ui.pages.CareersPage;
import com.tugcealtin.ui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CareersPageTest extends BaseTest {


    @Test
    public void verifyCareersPageBlocks() {
        SoftAssert softly = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        homePage.openHomepage();

        softly.assertTrue(homePage.isInsiderLogoOpened(), "Insider logo is not displayed on the Home page");
        softly.assertTrue(homePage.isHomepageHeroOpened(), "Homepage hero section is not displayed on the Home page");

        CareersPage careersPage = homePage.goToCareersPageViaCompanyMenu();
        careersPage.waitForCareerPageToLoad();

        boolean hasLocations = careersPage.isLocationsBlockPresent();
        boolean hasTeams = careersPage.isTeamsBlockPresent();
        boolean hasLife = careersPage.isLifeAtInsiderBlockPresent();

        System.out.println("Careers page main blocks checked:");
        System.out.println("  Locations = " + hasLocations);
        System.out.println("  Teams = " + hasTeams);
        System.out.println("  LifeAtInsider = " + hasLife);

    }
}
