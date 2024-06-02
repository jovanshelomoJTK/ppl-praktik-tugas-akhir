Feature: Get User by id Functionality

  Scenario: Operasi tidak menggunakan app-id
    When GET request ke "/user/60d0fe4f5311236168a109ca"
    Then Status code yang diterima adalah 403
    And Response body yang diterima adalah error message "APP_ID_MISSING"

  Scenario: Operasi menggunakan app-id yang tidak valid
    When Mengatur app-id dengan "abcdef"
    And GET request ke "/user/60d0fe4f5311236168a109ca"
    Then Status code yang diterima adalah 403
    And Response body yang diterima adalah error message "APP_ID_NOT_EXIST"

  Scenario: Operasi menggunakan app-id yang valid namun menggunakan id user yang tidak valid (tidak ada pada sistem)
    When Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And GET request ke "/user/aaaaaaaaaaaaaaaaaaaaaaaa"
    Then Status code yang diterima adalah 404
    And Response body yang diterima adalah error message "RESOURCE_NOT_FOUND"

  Scenario: Operasi menggunakan app-id yang valid dan menggunakan id user yang valid (ada pada sistem)
    When Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And GET request ke "/user/60d0fe4f5311236168a109ca"
    Then Status code yang diterima adalah 200
    And Response body yang diterima adalah data user dengan id "60d0fe4f5311236168a109ca"

  Scenario: Operasi menggunakan app-id yang valid dan menggunakan id user yang sudah dihapus
    Given User dengan id "60d0fe4f5311236168a109cb" sudah dihapus menggunakan app-id "665b6e07b65da9787569fa70"
    When Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And GET request ke "/user/60d0fe4f5311236168a109cb"
    Then Status code yang diterima adalah 404
    And Response body yang diterima adalah error message "RESOURCE_NOT_FOUND"
