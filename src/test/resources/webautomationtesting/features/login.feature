Feature: Login Functionality

  Background:
    Given Pengguna sudah berada pada halaman login

  Scenario: Login dengan username dan password yang terdaftar pada sistem
    When Pengguna memasukan username "standard_user"
    And Pengguna memasukan password "secret_sauce"
    And Pengguna menekan tombol login
    Then Aplikasi menampilkan halaman dashboard

  Scenario: Login dengan username yang terdaftar dan password tidak sesuai
    When Pengguna memasukan username "standard_user"
    And Pengguna memasukan password "secret_pass"
    And Pengguna menekan tombol login
    Then field "username" berindikator error
    And field "password" berindikator error
    Then Aplikasi menampilkan pesan error "Username and password do not match any user in this service !"

  Scenario: Login dengan username dan password tidak terisi
    When Pengguna menekan tombol login
    Then field "username" berindikator error
    And field "password" berindikator error
    And Aplikasi menampilkan pesan error "You need Username & Password !"
