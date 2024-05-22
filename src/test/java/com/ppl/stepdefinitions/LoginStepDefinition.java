package com.ppl.stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;

import com.ppl.hooks.Hooks;
import com.ppl.pages.LoginPage;

public class LoginStepDefinition {

    private WebDriver driver = Hooks.driver;

    private LoginPage loginPage = new LoginPage(driver);

    @Given("Pengguna sudah berada pada halaman login")
    public void Pengguna_sudah_berada_pada_halaman_login() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("Pengguna memasukan username {string}")
    public void Pengguna_memasukan_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("Pengguna memasukan password {string}")
    public void Pengguna_memasukan_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("Pengguna menekan tombol login")
    public void Pengguna_menekan_tombol_login() {
        loginPage.clickLoginButton();
    }

    @Then("Aplikasi menampilkan halaman dashboard")
    public void Aplikasi_menampilkan_halaman_dashboard() {
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("inventory.html"));
    }

    @Then("Aplikasi menampilkan pesan error {string}")
    public void Aplikasi_menampilkan_pesan_error(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue(actualErrorMessage.equals(errorMessage));
    }
}
