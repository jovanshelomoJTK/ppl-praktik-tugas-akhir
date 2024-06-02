package com.ppl.webautomationtesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ppl.webautomationtesting.helper.Helper;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    @FindBy(css = "[data-test='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "[data-test='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "[data-test='postalCode']")
    private WebElement postalCodeField;

    @FindBy(css = "[data-test='continue']")
    private WebElement continueButton;

    @FindBy(css = "[data-test='finish']")
    private WebElement finishButton;

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean isCheckoutPage() {
        return Helper.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html");
    }

    public boolean isOverviewPage() {
        return Helper.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }

    public boolean isSuccessfulCheckoutPage() {
        return Helper.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html");
    }
}
