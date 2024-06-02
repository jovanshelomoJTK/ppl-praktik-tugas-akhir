package com.ppl.webautomationtesting.stepdefinitions;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ppl.webautomationtesting.pages.CartPage;
import com.ppl.webautomationtesting.pages.CheckoutPage;
import com.ppl.webautomationtesting.pages.DashboardPage;
import com.ppl.webautomationtesting.pages.LoginPage;

public class CartStepDefinition {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();

    @Given("Aplikasi sudah berada pada halaman Cart dengan {int} barang")
    public void Aplikasi_sudah_berada_pada_halaman_Cart_dengan_barang(int i) {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        if (i == 1) {
            dashboardPage.clickAddToCartFirstProductButton();
        }

        dashboardPage.clickShoppingCartIcon();
    }

    @Given("Aplikasi sudah berada pada halaman Cart")
    public void Aplikasi_sudah_berada_pada_halaman_Cart() {
        dashboardPage.clickShoppingCartIcon();
    }

    @When("Pengguna menekan tombol Checkout")
    public void Pengguna_menekan_tombol_Checkout() {
        cartPage.clickCheckoutButton();
    }

    @When("Pengguna menekan tombol Continue Shopping")
    public void Pengguna_menekan_tombol_Continue_Shopping() {
        cartPage.clickContinueShoppingButton();
    }

    @Then("Pengguna diarahkan ke halaman checkout")
    public void Pengguna_diarahkan_ke_halaman_checkout() {
        assertTrue(checkoutPage.isCheckoutPage());
    }

    @Then("Pengguna diarahkan ke halaman dashboard")
    public void Pengguna_diarahkan_ke_halaman_dashboard() {
        assertTrue(dashboardPage.isDashboardPage());
    }
}
