package com.ppl.webautomationtesting.stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ppl.webautomationtesting.pages.DashboardPage;
import com.ppl.webautomationtesting.pages.LoginPage;

public class DashboardStepDefinition {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();

    @Given("Aplikasi sudah berada pada halaman dashboard")
    public void Pengguna_sudah_berada_pada_halaman_dashboard() {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Given("Barang pertama sudah dimasukan ke Cart")
    public void Barang_pertama_sudah_dimasukan_ke_Cart() {
        dashboardPage.clickAddToCartFirstProductButton();
    }

    @Then("Aplikasi menampilkan seluruh barang")
    public void Aplikasi_menampilkan_seluruh_barang() {
        assertTrue(dashboardPage.isInventoryListVisible());
    }

    @When("Pengguna menekan tombol {string} pada barang pertama")
    public void Pengguna_menekan_tombol_pada_barang_pertama(String string) {
        if (string.equals("Add to cart")) {
            dashboardPage.clickAddToCartFirstProductButton();
        } else if (string.equals("Remove")) {
            dashboardPage.clickRemoveFirstProductButton();
        }
    }

    @When("Pengguna menekan icon cart")
    public void Pengguna_menekan_icon_cart() {
        dashboardPage.clickShoppingCartIcon();
    }

    @Then("Tombol {string} pada barang pertama berubah menjadi {string}")
    public void Tombol_pada_barang_pertama_berubah_menjadi(String s, String s2) {
        if (s.equals("Add to cart")) {
            assertFalse(dashboardPage.isAddToCartFirstProductButtonVisible());
        } else if (s.equals("Remove")) {
            assertFalse(dashboardPage.isRemoveFirstProductButtonVisible());
        }

        if (s2.equals("Add to cart")) {
            assertTrue(dashboardPage.isAddToCartFirstProductButtonVisible());
        } else if (s2.equals("Remove")) {
            assertTrue(dashboardPage.isRemoveFirstProductButtonVisible());
        }
    }

    @Then("Angka pada notifikasi icon cart hilang")
    public void Angka_pada_notifikasi_icon_cart_hilang() {
        assertFalse(dashboardPage.isShoppingCartBadgeVisible());
    }

    @Then("Angka pada notifikasi icon cart menjadi {int}")
    public void Angka_pada_notifikasi_icon_cart_menjadi(int i) {
        assertEquals(i, dashboardPage.getShoppingCartBadgeCount());
    }
}
