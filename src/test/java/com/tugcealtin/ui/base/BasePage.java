package com.tugcealtin.ui.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String BASE_URL = "https://useinsider.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void hover(By locator) {
        WebElement element = waitForVisible(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    protected void click(By locator) {
        waitForVisible(locator).click();
    }

    protected WebElement scrollToElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element;

        } catch (Exception e) {
            System.out.println("Failed to scroll to element: " + locator);
            throw e;
        }
    }

}
