Feature: Checkout Functionality

  Background:
    Given Sudah ada barang pada Cart

  Scenario: Checkout barang pada cart dengan informasi checkout valid
    Given Pengguna sudah berada pada halaman checkout
    When Pengguna mengisi First Name dengan "John"
    And Pengguna mengisi Last Name dengan "Doe"
    And Pengguna mengisi Zip Postal Code dengan "12345"
    And Pengguna menekan tombol Continue
    Then Aplikasi menampilkan halaman overview

  Scenario: Menekan tombol Finish pada Halaman overview pembayaran
    Given Pengguna sudah mengisi informasi checkout dengan valid
    And Pengguna sudah berada pada halaman overview
    When Pengguna menekan tombol Finish
    Then Aplikasi menampilkan halaman pembelian berhasil

  Scenario: Checkout barang pada cart dengan informasi checkout tidak ada yang terisi
    Given Pengguna sudah berada pada halaman checkout
    When Pengguna menekan tombol Continue
    Then Aplikasi menampilkan pesan error "First Name, Last Name, and Zip/Postal Code is required!"
