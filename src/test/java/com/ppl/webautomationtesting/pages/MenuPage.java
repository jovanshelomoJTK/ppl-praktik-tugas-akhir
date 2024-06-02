package com.ppl.webautomationtesting.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ppl.webautomationtesting.helper.Helper;

public class MenuPage {

    public MenuPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement closeButton;

    @FindBy(className = "bm-menu-wrap")
    private WebElement menu;

    @FindBy(css = "[data-test='inventory-sidebar-link']")
    private WebElement AllItemsButton;

    @FindBy(css = "[data-test='logout-sidebar-link']")
    private WebElement logoutButton;

    public void clickMenuButton() {
        menuButton.click();
        // wait for menu to be visible
        Helper.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void clickAllItemsButton() {
        AllItemsButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
        // wait for menu to be invisible
        Wait<WebDriver> wait = new WebDriverWait(Helper.getDriver(), Duration.ofSeconds(2));
        wait.until(driver -> !isMenuVisible());
    }

    public boolean isMenuVisible() {
        try {
            return menu.getAttribute("hidden") == null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
