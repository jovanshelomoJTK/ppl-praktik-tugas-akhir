package com.ppl.webautomationtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ppl.webautomationtesting.helper.Helper;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    @FindBy(css = "[data-test='inventory-list']")
    private WebElement inventoryList;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;

    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;

    @FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartFirstProductButton;

    @FindBy(css = "[data-test='remove-sauce-labs-backpack']")
    private WebElement removeFirstProductButton;

    @FindBy(css = "[data-test='item-4-img-link']")
    private WebElement firstProductImage;

    public boolean isDashboardPage() {
        return Helper.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public boolean isInventoryListVisible() {
        try {
            return inventoryList.findElements(By.cssSelector(
                    "[data-test='inventory-item']")).size() > 0;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickShoppingCartIcon() {
        shoppingCartLink.click();
    }

    public int getShoppingCartBadgeCount() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public boolean isShoppingCartBadgeVisible() {
        try {
            return shoppingCartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAddToCartFirstProductButtonVisible() {
        try {
            return addToCartFirstProductButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isRemoveFirstProductButtonVisible() {
        try {
            return removeFirstProductButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickAddToCartFirstProductButton() {
        addToCartFirstProductButton.click();
    }

    public void clickRemoveFirstProductButton() {
        removeFirstProductButton.click();
    }

    public void clickFirstProduct() {
        firstProductImage.click();
    }

}
