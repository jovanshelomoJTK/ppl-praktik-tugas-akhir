Feature: End to End Testing

  Scenario: Checkout suatu barang pada aplikasi SWAG labs
    Given Pengguna sudah berada pada halaman login
    When Pengguna memasukan username "standard_user"
    And Pengguna memasukan password "secret_sauce"
    And Pengguna menekan tombol login
    And Pengguna menekan tombol "Add to Cart" pada barang pertama
    And Pengguna menekan icon cart
    And Pengguna menekan tombol Checkout
    And Pengguna mengisi First Name dengan "Lebron"
    And Pengguna mengisi Last Name dengan "James"
    And Pengguna mengisi Zip Postal Code dengan "40121"
    And Pengguna menekan tombol Continue
    And Pengguna menekan tombol Finish
    Then Aplikasi menampilkan halaman pembelian berhasil
