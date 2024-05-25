Feature: Logout Functionality

  Scenario: Pengguna logout dari aplikasi
    Given Pengguna sudah login dengan berhasil
    When Pengguna menekan tombol menu bar
    And Pengguna menekan tombol logout
    Then Aplikasi menampilkan halaman login