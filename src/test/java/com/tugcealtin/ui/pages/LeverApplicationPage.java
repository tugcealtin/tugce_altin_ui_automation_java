package com.tugcealtin.ui.pages;

import com.tugcealtin.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeverApplicationPage extends BasePage {

    private final By leverLogo = By.cssSelector(".main-header-logo");
    private final By applicationForButton = By.cssSelector(".postings-btn-wrapper");

    public LeverApplicationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLeverPageOpened() {
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);

            boolean isLeverUrl = currentUrl.contains("jobs.lever.co");
            System.out.println("Is Lever URL: " + isLeverUrl);
            waitForVisible(leverLogo);
            waitForVisible(applicationForButton);
            return isLeverUrl;
        } catch (Exception e) {
            System.out.println("Error checking Lever page: " + e.getMessage());
            return false;
        }
    }

    public void switchToLeverTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}

