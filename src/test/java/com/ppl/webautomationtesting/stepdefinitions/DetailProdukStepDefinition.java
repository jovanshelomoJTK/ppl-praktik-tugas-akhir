package com.ppl.webautomationtesting.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ppl.webautomationtesting.pages.DashboardPage;
import com.ppl.webautomationtesting.pages.DetailProdukPage;
import com.ppl.webautomationtesting.pages.LoginPage;

import io.cucumber.java.en.*;

public class DetailProdukStepDefinition {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    DetailProdukPage detailProdukPage = new DetailProdukPage();

    @Given("Aplikasi berada pada halaman detail produk pertama")
    public void Aplikasi_berada_pada_halaman_detail_produk_pertama() {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        dashboardPage.clickFirstProduct();
    }

    @Given("Barang sudah ditambahkan ke Cart")
    public void Barang_sudah_ditambahkan_ke_Cart() {
        detailProdukPage.clickAddToCartButton();
    }

    @When("Pengguna menekan tombol {string}")
    public void Pengguna_menekan_tombol(String s) {
        if (s.equals("Add to Cart")) {
            detailProdukPage.clickAddToCartButton();
        } else if (s.equals("Remove")) {
            detailProdukPage.clickRemoveButton();
        }
    }

    @Then("Aplikasi menampilkan detail produk yang dipilih")
    public void Aplikasi_menampilkan_detail_produk_yang_dipilih() {
        assertTrue(detailProdukPage.isDetailProdukPage(4));
    }

    @Then("Tombol {string} pada barang berubah menjadi {string}")
    public void Tombol_pada_barang_berubah_menjadi(String s, String s2) {
        if (s.equals("Add to Cart")) {
            assertFalse(detailProdukPage.isAddToCartButtonVisible());
        } else if (s.equals("Remove")) {
            assertFalse(detailProdukPage.isRemoveButtonVisible());
        }

        if (s2.equals("Add to Cart")) {
            assertTrue(detailProdukPage.isAddToCartButtonVisible());
        } else if (s2.equals("Remove")) {
            assertTrue(detailProdukPage.isRemoveButtonVisible());
        }
    }
}
