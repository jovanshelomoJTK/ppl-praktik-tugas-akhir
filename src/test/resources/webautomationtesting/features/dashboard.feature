Feature: dashboard Functionality

  Background:
    Given Aplikasi sudah berada pada halaman dashboard

  Scenario: Verifikasi menampilkan seluruh barang
    Then Aplikasi menampilkan seluruh barang

  Scenario: Menambahkan barang ke Cart
    When Pengguna menekan tombol "Add to cart" pada barang pertama
    Then Tombol "Add to cart" pada barang pertama berubah menjadi "Remove"
    And Angka pada notifikasi icon cart menjadi 1

  Scenario: Menghapus barang dari Cart
    Given Barang pertama sudah dimasukan ke Cart
    When Pengguna menekan tombol "Remove" pada barang pertama
    Then Angka pada notifikasi icon cart hilang
