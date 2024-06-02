package com.ppl.webautomationtesting.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ppl.webautomationtesting.helper.Helper;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(css = "#user-name + svg")
    private WebElement usernameFieldErrorIcon;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "#password + svg")
    private WebElement passwordFieldErrorIcon;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public void open() {
        Helper.getDriver().get("https://www.saucedemo.com/");
    }

    public boolean isLoginPage() {
        return Helper.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public boolean isUsernameFieldError() {
        // check if username field has class "error"
        String[] classNames = usernameField.getAttribute("class").split(" ");
        boolean isRedUnderlined = false;
        for (String className : classNames) {
            if (className.equals("error")) {
                isRedUnderlined = true;
                break;
            }
        }

        boolean isXIconVisible = false;
        try {
            isXIconVisible = usernameFieldErrorIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            isXIconVisible = false;
        }

        return isRedUnderlined && isXIconVisible;
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public boolean isPasswordFieldError() {
        // check if password field has class "error"
        String[] classNames = passwordField.getAttribute("class").split(" ");
        boolean isRedUnderlined = false;
        for (String className : classNames) {
            if (className.equals("error")) {
                isRedUnderlined = true;
                break;
            }
        }

        boolean isXIconVisible = false;
        try {
            isXIconVisible = passwordFieldErrorIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            isXIconVisible = false;
        }

        return isRedUnderlined && isXIconVisible;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
