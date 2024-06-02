package com.ppl.webautomationtesting.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ppl.webautomationtesting.pages.LoginPage;
import com.ppl.webautomationtesting.pages.MenuPage;

import io.cucumber.java.en.*;

public class MenuStepDefinition {

    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();

    @Given("Menu sudah terbuka")
    public void Menu_sudah_terbuka() {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        menuPage.clickMenuButton();
    }

    @When("Pengguna menekan icon close")
    public void Pengguna_menekan_icon_close() {
        menuPage.clickCloseButton();
    }

    @When("Pengguna menekan tombol All items")
    public void Pengguna_menekan_tombol_All_items() {
        menuPage.clickAllItemsButton();
    }

    @When("Pengguna menekan tombol logout")
    public void Pengguna_menekan_tombol_logout() {
        menuPage.clickLogoutButton();
    }

    @Then("Aplikasi menutup bar menu")
    public void Aplikasi_menutup_bar_menu() {
        assertFalse(menuPage.isMenuVisible());
    }

    @Then("Aplikasi menampilkan halaman login")
    public void Aplikasi_menampilkan_halaman_login() {
        assertTrue(loginPage.isLoginPage());
    }

}
