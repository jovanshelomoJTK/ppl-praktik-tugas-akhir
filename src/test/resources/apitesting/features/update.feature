Feature: Update User Functionality

  Scenario: Update first name  user dengan data valid, menggunakan header app-id yang valid dan id user yang valid
    When Mengatur body request dengan data
      """
      {
        "firstName": "Anya"
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And PUT request ke "/user/60d0fe4f5311236168a109cc"
    Then Status code yang diterima adalah 200
    And Response body yang diterima adalah data user dengan first name "Anya"

  Scenario: Update first name user dengan data selain string, menggunakan header app-id yang valid dan id user yang valid
    When Mengatur body request dengan data
      """
      {
        "firstName": 50
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And PUT request ke "/user/60d0fe4f5311236168a109cc"
    Then Status code yang diterima adalah 400
    And Response body yang diterima adalah error message "BODY_NOT_VALID"

  Scenario: Update first name user dengan panjang data  kurang dari 2, menggunakan header app-id yang valid dan id user yang valid
    When Mengatur body request dengan data
      """
      {
        "firstName": "a"
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And PUT request ke "/user/60d0fe4f5311236168a109cc"
    Then Status code yang diterima adalah 400
    And Response body yang diterima adalah error message "BODY_NOT_VALID"

  Scenario: Update gender user dengan data selain "male", "female", "other", "", menggunakan header app-id yang valid dan id user yang valid
    When Mengatur body request dengan data
      """
      {
      "gender": "gender fluid"
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And PUT request ke "/user/60d0fe4f5311236168a109cc"
    Then Status code yang diterima adalah 400
    And Response body yang diterima adalah error message "BODY_NOT_VALID"

  Scenario: Update  seluruh data suatu user dengan data valid, menggunakan header app-id yang valid dan id user yang valid
    When Mengatur body request dengan data
      """
      {
        "title": "mr",
        "firstName": "Alpha",
        "lastName": "Innova",
        "picture": "https://static.vecteezy.com/system/resources/previews/009/292/244/original/default-avatar-icon-of-social-media-user-vector.jpg",
        "gender": "male",
        "dateOfBirth": "2000-06-21T18:00:29Z",
        "phone": "022 - 2015271",
        "location": {
            "street": "10110, Gambir",
            "city": "Jakarta",
            "state": "DKI Jakarta¡",
            "country": "Indonesia",
            "timezone": "+7:00"
        }
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And PUT request ke "/user/60d0fe4f5311236168a109cc"
    Then Status code yang diterima adalah 200
    And Response body yang diterima adalah data user dengan isi
      """
      {
        "title": "mr",
        "firstName": "Alpha",
        "lastName": "Innova",
        "picture": "https://static.vecteezy.com/system/resources/previews/009/292/244/original/default-avatar-icon-of-social-media-user-vector.jpg",
        "gender": "male",
        "dateOfBirth": "2000-06-21T18:00:29Z",
        "phone": "022 - 2015271",
        "location": {
            "street": "10110, Gambir",
            "city": "Jakarta",
            "state": "DKI Jakarta¡",
            "country": "Indonesia",
            "timezone": "+7:00"
        }
      }
      """
