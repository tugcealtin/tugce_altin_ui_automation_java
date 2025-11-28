package com.tugcealtin.ui.tests;

import com.tugcealtin.ui.base.BaseTest;
import com.tugcealtin.ui.pages.LeverApplicationPage;
import com.tugcealtin.ui.pages.QAJobsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class QAJobsPageTest extends BaseTest {


    @Test
    public void verifyQAJobsInIstanbul() {
        SoftAssert softly = new SoftAssert();

        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.openQAJobsPage();
        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.scrollToFilter();
        qaJobsPage.waitForDepartmentQAFilter();
        qaJobsPage.filterByLocation("Istanbul, Turkiye");

        qaJobsPage.scrollToJobCard();

        boolean jobsListPresent = qaJobsPage.isJobsListPresent();
        softly.assertTrue(jobsListPresent, "Jobs list is not present after filtering");
        boolean allJobsValid = qaJobsPage.verifyAllJobsContain(
                "Quality Assurance",
                "Quality Assurance",
                "Istanbul, Turkiye"
        );
        softly.assertTrue(allJobsValid, "Not all jobs contain the expected Position, Department, and Location");

        LeverApplicationPage leverPage = qaJobsPage.clickViewRole();
        leverPage.switchToLeverTab();
        boolean isLeverPageOpened = leverPage.isLeverPageOpened();
        softly.assertTrue(isLeverPageOpened, "View Role button did not redirect to Lever Application page");
        softly.assertAll();
    }
}
