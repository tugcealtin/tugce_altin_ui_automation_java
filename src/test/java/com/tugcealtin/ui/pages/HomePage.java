package com.tugcealtin.ui.pages;

import com.tugcealtin.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By insiderLogo = By.cssSelector("[alt='insider_logo']");
    private final By headerMenu = By.id("navbarNavDropdown");
    private final By companyMenu = By.xpath("//a[contains(text(), 'Company')]"); //mouse over ile açılan menü
    private final By careersLinkInMenu = By.xpath("//a[contains(text(), 'Careers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public boolean isInsiderLogoOpened() {
        return waitForVisible(insiderLogo).isDisplayed();
    }
    public boolean isHeaderMenuOpened() {
        return waitForVisible(headerMenu).isDisplayed();
    }
    public void goToCareersPageFromCompanyMenu() {
        hover(companyMenu);
        click(careersLinkInMenu);
    }

}

