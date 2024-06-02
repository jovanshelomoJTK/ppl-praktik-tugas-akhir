Feature: Menu Functionality

  Background:
    Given Menu sudah terbuka

  Scenario: Pengguna logout dari aplikasi
    When Pengguna menekan tombol logout
    Then Aplikasi menampilkan halaman login

  Scenario: Pengguna menutup menu
    When Pengguna menekan icon close
    Then Aplikasi menutup bar menu

  Scenario: Pengguna memilih menu All items
    When Pengguna menekan tombol All items
    Then Aplikasi menampilkan halaman dashboard
