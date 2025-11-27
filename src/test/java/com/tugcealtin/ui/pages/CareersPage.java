package com.tugcealtin.ui.pages;
import com.tugcealtin.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void waitForCareerPageToLoad() {
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/careers/"));
    }

    private By createBlockLocator(String blockName) {
        return By.xpath("//h2[contains(text(),'" + blockName + "')]");
    }
    private boolean isBlockPresent(String blockName) {
        return !driver.findElements(createBlockLocator(blockName)).isEmpty();
    }

    public boolean isLocationsBlockPresent() {
        return isBlockPresent("Location");
    }
    public boolean isTeamsBlockPresent() {
        return isBlockPresent("Team");
    }
    public boolean isLifeAtInsiderBlockPresent() {
        return isBlockPresent("Life at Insider");
    }
}
