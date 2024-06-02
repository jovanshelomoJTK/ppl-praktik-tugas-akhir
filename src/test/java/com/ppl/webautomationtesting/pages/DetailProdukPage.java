package com.ppl.webautomationtesting.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ppl.webautomationtesting.helper.Helper;

public class DetailProdukPage {

    public DetailProdukPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    @FindBy(css = "[data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(css = "[data-test='remove']")
    private WebElement removeButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public boolean isDetailProdukPage(int id) {
        return Helper.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/inventory-item.html?id=" + id);
    }

    public boolean isAddToCartButtonVisible() {
        try {
            return addToCartButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isRemoveButtonVisible() {
        try {
            return removeButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
