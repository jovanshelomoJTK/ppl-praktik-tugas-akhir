package com.ppl.webautomationtesting.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ppl.webautomationtesting.pages.CartPage;
import com.ppl.webautomationtesting.pages.CheckoutPage;
import com.ppl.webautomationtesting.pages.DashboardPage;
import com.ppl.webautomationtesting.pages.LoginPage;

import io.cucumber.java.en.*;

public class CheckoutStepDefinition {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();

    @Given("Sudah ada barang pada Cart")
    public void Sudah_ada_barang_pada_Cart() {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        dashboardPage.clickAddToCartFirstProductButton();
    }

    @Given("Pengguna sudah berada pada halaman overview")
    public void Pengguna_sudah_berada_pada_halaman_overview() {
        dashboardPage.clickShoppingCartIcon();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Lebron");
        checkoutPage.enterLastName("James");
        checkoutPage.enterPostalCode("40121");
        checkoutPage.clickContinueButton();
    }

    @Given("Pengguna sudah berada pada halaman checkout")
    public void Pengguna_sudah_berada_pada_halaman_checkout() {
        dashboardPage.clickShoppingCartIcon();
        cartPage.clickCheckoutButton();
    }

    @Given("Pengguna sudah mengisi informasi checkout dengan valid")
    public void Pengguna_sudah_mengisi_informasi_checkout_dengan_valid() {
        dashboardPage.clickShoppingCartIcon();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Lebron");
        checkoutPage.enterLastName("James");
        checkoutPage.enterPostalCode("40121");
    }

    @When("Pengguna mengisi First Name dengan {string}")
    public void Pengguna_mengisi_First_Name_dengan(String s) {
        checkoutPage.enterFirstName(s);
    }

    @When("Pengguna mengisi Last Name dengan {string}")
    public void Pengguna_mengisi_Last_Name_dengan(String s) {
        checkoutPage.enterLastName(s);
    }

    @When("Pengguna mengisi Zip Postal Code dengan {string}")
    public void Pengguna_mengisi_Zip_Postal_Code_dengan(String s) {
        checkoutPage.enterPostalCode(s);
    }

    @When("Pengguna menekan tombol Continue")
    public void Pengguna_menekan_tombol_Continue() {
        checkoutPage.clickContinueButton();
    }

    @When("Pengguna menekan tombol Finish")
    public void Pengguna_menekan_tombol_Finish() {
        checkoutPage.clickFinishButton();
    }

    @Then("Aplikasi menampilkan halaman overview")
    public void Aplikasi_menampilkan_halaman_overview() {
        assertTrue(checkoutPage.isOverviewPage());
    }

    @Then("Aplikasi menampilkan halaman pembelian berhasil")
    public void Aplikasi_menampilkan_halaman_pembelian_berhasil() {
        assertTrue(checkoutPage.isSuccessfulCheckoutPage());
    }
}
