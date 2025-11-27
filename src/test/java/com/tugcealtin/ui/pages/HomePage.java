package com.tugcealtin.ui.pages;

import com.tugcealtin.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By insiderLogo = By.cssSelector("[alt='insider_logo']");
    private final By homepageHero = By.cssSelector("[id='desktop_hero_24']");
    private final By companyMenu = By.xpath("//a[contains(text(), 'Company')]"); //mouse over ile açılan menü
    private final By careersLinkInMenu = By.xpath("//a[contains(text(), 'Careers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomepage() {
        driver.get(BASE_URL);
        return this;
    }

    public boolean isInsiderLogoOpened() {
        return waitForVisible(insiderLogo).isDisplayed();
    }
    public boolean isHomepageHeroOpened() {
        return waitForVisible(homepageHero).isDisplayed();
    }
    public CareersPage goToCareersPageViaCompanyMenu() {
        hover(companyMenu);
        click(careersLinkInMenu);
        return new CareersPage(driver);
    }

}

