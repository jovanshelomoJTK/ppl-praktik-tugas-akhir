package com.ppl.stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ppl.hooks.Hooks;
import com.ppl.pages.LoginPage;
import com.ppl.pages.LogoutPage;

public class LogoutStepDefinition {
    private WebDriver driver = Hooks.driver;

    private LoginPage loginPage = new LoginPage(driver);
    private LogoutPage logoutPage = new LogoutPage(driver);

    @Given("Pengguna sudah login dengan berhasil")
    public void Pengguna_sudah_login_dengan_berhasil() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("Pengguna menekan tombol menu bar")
    public void Pengguna_menekan_tombol_menu_bar() {
        logoutPage.clickMenuButton();
    }

    @And("Pengguna menekan tombol logout")
    public void Pengguna_menekan_tombol_logout() {
        logoutPage.clickLogoutButton();
    }

    @Then("Aplikasi menampilkan halaman login")
    public void Aplikasi_menampilkan_halaman_login() {
        boolean isLoginPage = loginPage.checkIsLoginPage();
        assertTrue(isLoginPage);
    }

}
