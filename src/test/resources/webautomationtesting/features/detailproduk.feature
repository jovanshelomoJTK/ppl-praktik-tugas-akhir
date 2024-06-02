Feature: Detail Produk Functionality

    Background:
        Given Aplikasi berada pada halaman detail produk pertama

    Scenario: Menampilkan detail suatu barang
        Then Aplikasi menampilkan detail produk yang dipilih

    Scenario: Menambahkan barang ke Cart
        When Pengguna menekan tombol "Add to Cart"
        Then Tombol "Add to Cart" pada barang berubah menjadi "Remove"
        And Angka pada notifikasi icon cart menjadi 1

    Scenario: Menghapus barang dari Cart
        Given Barang sudah ditambahkan ke Cart
        When Pengguna menekan tombol "Remove"
        Then Tombol "Remove" pada barang berubah menjadi "Add to Cart"
        And Angka pada notifikasi icon cart hilang
