package com.ppl.webautomationtesting.stepdefinitions;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ppl.webautomationtesting.pages.DashboardPage;
import com.ppl.webautomationtesting.pages.LoginPage;

public class LoginStepDefinition {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();

    @Given("Pengguna sudah berada pada halaman login")
    public void Pengguna_sudah_berada_pada_halaman_login() {
        loginPage.open();
    }

    @When("Pengguna memasukan username {string}")
    public void Pengguna_memasukan_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("Pengguna memasukan password {string}")
    public void Pengguna_memasukan_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("Pengguna menekan tombol login")
    public void Pengguna_menekan_tombol_login() {
        loginPage.clickLoginButton();
    }

    @Then("Aplikasi menampilkan halaman dashboard")
    public void Aplikasi_menampilkan_halaman_dashboard() {
        assertTrue(dashboardPage.isDashboardPage());
    }

    @Then("Aplikasi menampilkan pesan error {string}")
    public void Aplikasi_menampilkan_pesan_error(String errorMessage) {
        assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Then("field {string} berindikator error")
    public void field_bertanda_silang_merah(String field) {
        if (field.equals("username")) {
            assertTrue(loginPage.isUsernameFieldError());
        } else if (field.equals("password")) {
            assertTrue(loginPage.isPasswordFieldError());
        }
    }
}
