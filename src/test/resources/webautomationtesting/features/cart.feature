Feature: Cart Functionality

  Scenario: Menekan tombol Checkout ketika jumlah barang sebanyak 1
    Given Aplikasi sudah berada pada halaman Cart dengan 1 barang
    When Pengguna menekan tombol Checkout
    Then Pengguna diarahkan ke halaman checkout

  Scenario: Menekan tombol Continue Shopping ketika jumlah barang sebanyak 1
    Given Aplikasi sudah berada pada halaman Cart dengan 1 barang
    When Pengguna menekan tombol Continue Shopping
    Then Pengguna diarahkan ke halaman dashboard

  Scenario: Menekan tombol Checkout ketika jumlah barang sebanyak 0
    Given Aplikasi sudah berada pada halaman Cart dengan 0 barang
    When Pengguna menekan tombol Checkout
    Then Aplikasi menampilkan pesan error "You Need Item In Cart To Proceed Checkout Process"
