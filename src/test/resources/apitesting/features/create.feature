Feature: Create User Functionality

  Scenario: Membuat user dengan seluruh field valid
    When Mengatur body request dengan data
      """
        {
          "title": "mrs",
          "firstName": "Jennie",
          "lastName": "Kim",
          "gender": "female",
          "email": "jenniekim@gmail.com",
          "dateOfBirth": "1996-01-16T00:00:01.100Z",
          "phone": "+1234567890",
          "picture": "https://id.wikipedia.org/wiki/Jennie_(penyanyi)",
          "location": {
            "street": "Jalan",
            "city": "Bandung",
            "state": "Jawa Barat",
            "country": "Indonesia",
            "timezone": "+7:00"
          }
        }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And POST request ke "/user/create"
    Then Status code yang diterima adalah 200
    And Response body yang diterima adalah data user dengan isi
      """
        {
          "title": "mrs",
          "firstName": "Jennie",
          "lastName": "Kim",
          "gender": "female",
          "email": "jenniekim@gmail.com",
          "dateOfBirth": "1996-01-16T00:00:01.100Z",
          "phone": "+1234567890",
          "picture": "https://id.wikipedia.org/wiki/Jennie_(penyanyi)",
          "location": {
            "street": "Jalan",
            "city": "Bandung",
            "state": "Jawa Barat",
            "country": "Indonesia",
            "timezone": "+7:00"
          }
        }
      """

  Scenario: Membuat user dengan data input hanya berisi field first name, last name, dan email valid
    When Mengatur body request dengan data
      """
      {
        "firstName": "Park",
        "lastName": "Jisung",
        "email": "parkjisung@gmail.com"
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And POST request ke "/user/create"
    Then Status code yang diterima adalah 200
    And Response body yang diterima adalah data user dengan isi
      """
      {
        "firstName": "Park",
        "lastName": "Jisung",
        "email": "parkjisung@gmail.com"
      }
      """

  Scenario: Membuat user dengan field first name, last name, dan email tidak ada
    When Mengatur body request dengan data
      """
      {
        "title": "mrs",
        "gender": "female",
        "dateOfBirth": "1996-01-16T00:00:01.100Z",
        "phone": "+1234567890",
        "picture": "https://id.wikipedia.org/wiki/Jennie_(penyanyi)",
        "location": {
          "street": "Jalan",
          "city": "Bandung",
          "state": "Jawa Barat",
          "country": "Indonesia",
          "timezone": "+7:00"
        }
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And POST request ke "/user/create"
    Then Status code yang diterima adalah 400
    And Response body yang diterima adalah error message "BODY_NOT_VALID"

  Scenario: Membuat user dengan field first name diisi dengan selain format string
    When Mengatur body request dengan data
      """
      {
        "title": "mrs",
        "firstName": 12345,
        "lastName": "Kim",
        "gender": "female",
        "email": "jenniekimbp2@email.com",
        "dateOfBirth": "1996-01-16T00:00:01.100Z",
        "phone": "+1234567890",
        "picture": "https://id.wikipedia.org/wiki/Jennie_(penyanyi)",
        "location": {
            "street": "Jalan",
            "city": "Bandung",
            "state": "Jawa Barat",
            "country": "Indonesia",
            "timezone": "+7:00"
        }
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And POST request ke "/user/create"
    Then Status code yang diterima adalah 400
    And Response body yang diterima adalah error message "BODY_NOT_VALID"

  Scenario: Membuat user dengan field first name diisi dengan jumlah karakter tidak sesuai
    When Mengatur body request dengan data
      """
      {
        "title": "mrs",
        "firstName": "J",
        "lastName": "Kim",
        "gender": "female",
        "email": "jenniekimbp3@gmail.com",
        "dateOfBirth": "1996-01-16T00:00:01.100Z",
        "phone": "+1234567890",
        "picture": "https://id.wikipedia.org/wiki/Jennie_(penyanyi)",
        "location": {
            "street": "Jalan",
            "city": "Bandung",
            "state": "Jawa Barat",
            "country": "Indonesia",
            "timezone": "+7:00"
        }
      }
      """
    And Mengatur app-id dengan "665b6e07b65da9787569fa70"
    And POST request ke "/user/create"
    Then Status code yang diterima adalah 400
    And Response body yang diterima adalah error message "BODY_NOT_VALID"
