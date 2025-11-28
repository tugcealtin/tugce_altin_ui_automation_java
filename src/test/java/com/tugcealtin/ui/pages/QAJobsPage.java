package com.tugcealtin.ui.pages;

import com.tugcealtin.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class QAJobsPage extends BasePage {

    private final By seeAllQAJobsButton = By.xpath("//a[contains(text(), 'See all QA jobs')]");
    private final By filterComponent = By.id("filter-menu");
    private final By locationFilter = By.id("select2-filter-by-location-container");
    private final By departmentFilterForQA = By.cssSelector("[title='Quality Assurance']");
    private final By jobsList = By.id("jobs-list");
    private final By jobCard = By.cssSelector("[id='jobs-list'] > div");
    private final By viewRoleButton = By.xpath("(//a[contains(text(), 'View Role')])[1]");

    // Job card içindeki elementler
    private final By jobPosition = By.cssSelector("[id='jobs-list'] p");
    private final By jobDepartment = By.cssSelector("[id='jobs-list'] span");
    private final By jobLocation = By.cssSelector("[id='jobs-list'] > div > div div");

    public QAJobsPage(WebDriver driver) {
        super(driver);
    }

    public void openQAJobsPage() {
        driver.get(BASE_URL + "/careers/quality-assurance/");
    }

    public void clickSeeAllQAJobs() {
        click(seeAllQAJobsButton);
    }

    public void scrollToFilter() {
        scrollToElement(filterComponent);
    }

    public void waitForDepartmentQAFilter() {
        waitForVisible(departmentFilterForQA);
    }

    public void  filterByLocation(String location) {
        click(locationFilter);
        By locationOption = By.xpath("//li[contains(text(), '" + location + "')]");
        scrollToElement(locationOption);
        click(locationOption);
    }

    public void scrollToJobCard() {
        scrollToElement(jobPosition);
    }

    public boolean isJobsListPresent() {
        waitForVisible(jobsList);
        List<WebElement> jobs = driver.findElements(jobsList);
        return !jobs.isEmpty();
    }

    public List<WebElement> getAllJobs() {
        return driver.findElements(jobsList);
    }

    public boolean verifyAllJobsContain(String expectedPosition, String expectedDepartment, String expectedLocation) {
        List<WebElement> jobs = getAllJobs();

        System.out.println("Total jobs found: " + jobs.size());

        for (int i = 0; i < jobs.size(); i++) {
            WebElement job = jobs.get(i);

            String position = job.findElement(jobPosition).getText();
            String department = job.findElement(jobDepartment).getText();
            String location = job.findElement(jobLocation).getText();

            System.out.println("Job #" + (i + 1) + ":");
            System.out.println("Position: " + position);
            System.out.println("Department: " + department);
            System.out.println("Location: " + location);

            if (!position.contains(expectedPosition)) {
                System.out.println("Position does not contain: " + expectedPosition);
                return false;
            }
            if (!department.contains(expectedDepartment)) {
                System.out.println("Department does not contain: " + expectedDepartment);
                return false;
            }
            if (!location.contains(expectedLocation)) {
                System.out.println("Location does not contain: " + expectedLocation);
                return false;
            }
            System.out.println("Job verified successfully");
        }

        return true;
    }

    public LeverApplicationPage clickViewRole() {
        hoverOverJobCard();
        click(viewRoleButton);
        return new LeverApplicationPage(driver);
    }

    private void hoverOverJobCard() {
        hover(jobCard);
    }

}
