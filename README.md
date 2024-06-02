# Project Web Automation Testing & API Testing

Proyek web automation testing untuk menguji fitur login dan logout pada web https://www.saucedemo.com/. Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan Maven (build tools).

# Build With

Proyek pengujian otomatis melibatkan 8 buah dependency.

## Dependency:

- webdrivermanager
- selenium-java
- cucumber-java
- cucumber-junit-platform-engine
- junit-platform-suite
- junit-jupiter
- rest assured
- hamcrest
- jsonassert

# Getting Started

## Prerequisite

Sebelum menjalankan proyek ini, diperlukan persyaratan environment yang harus disiapkan pada device eksekusi proyek

1. JDK 8+
2. Maven

## Run Test

Berikut adalah proses menjalankan proyek ini pada local environment:

1. Clone repository github ini
2. Buka pada IDE(Visual Studio Code, IntelliJ IDEA, dll)
3. Buka folder hasil clone pada Visual Studio Code
4. Buka terminal
5. Ketikan perintah di bawah ini untuk eksekusi test script dan generate test report
   ```
   mvn test
   ```
6. Buka hasil test report pada folder yang berada pada path

   1. `target/cucumber-reports-api/` untuk API Automatic Testing
   2. `target/cucumber-reports-web/` untuk Web Automatic Testing

   Masing-masing folder berisi file berikut:

   - Folder Timeline: `CucumberTimeline`
   - HTML: `Cucumber.html` <b>(File utama untuk melihat hasil test report)</b>
   - JSON: `Cucumber.json`
   - XML: `Cucumber.xml`

## File Configuration

Proses konfigurasi project menggunakan build automation pada file pom.xml

1.  Semua dependency yang dibutuhkan harus ditambahkan di dalam dependencies pada pom.xml. Berikut dependency yang dibutuhkan:

    - webdrivermanager, menyediakan utilitas untuk mengelola driver browser otomatis

    ```xml
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.8.0</version>
    </dependency>
    ```

    - selenium-java, menyediakan API untuk mengotomatisasi browser

    ```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.20.0</version>
    </dependency>
    ```

    - cucumber-java, menyediakan integrasi Java untuk Cucumber

    ```xml
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <scope>test</scope>
    </dependency>
    ```

    - cucumber-junit-platform-engine, menyediakan integrasi dengan JUnit Platform

    ```xml
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit-platform-engine</artifactId>
        <scope>test</scope>
    </dependency>
    ```

    - junit-platform-suite, menyediakan kerangka kerja untuk menjalankan pengujian dengan JUnit Platform

    ```xml
    <dependency>
        <groupId>org.junit.platform</groupId>
        <artifactId>junit-platform-suite</artifactId>
        <scope>test</scope>
    </dependency>
    ```

    - junit-jupiter, menyediakan API dan implementasi untuk JUnit Jupiter, bagian dari JUnit 5

    ```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <scope>test</scope>
    </dependency>
    ```

    - rest assured, menyediakan API untuk pengujian RESTful Web Service

    ```xml
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.4.0</version>
        <scope>test</scope>
    </dependency>
    ```

    - hamcrest, menyediakan matcher untuk Rest Assured

    ```xml
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest</artifactId>
        <version>2.2</version>
    </dependency>
    ```

    - jsonassert, menyediakan assertion untuk JSON

    ```xml
    <dependency>
        <groupId>org.skyscreamer</groupId>
        <artifactId>jsonassert</artifactId>
        <version>1.5.1</version>
        <scope>test</scope>
    </dependency>
    ```

# Structure Project Test

Tujuan project adalah proses pengujian automation web https://www.saucedemo.com/ dan https://dummyapi.io/ sehingga kode program tersimpan dalam folder test. Berikut struktur proyek:

```
src
┗ test
  ┣ java
  ┃ ┗ com
  ┃   ┗ ppl
  ┃     ┣ apitesting
  ┃     ┃ ┣ helper
  ┃     ┃ ┃ ┗ Helper.java
  ┃     ┃ ┣ hooks
  ┃     ┃ ┃ ┗ Hooks.java
  ┃     ┃ ┣ stepdefinitions
  ┃     ┃ ┃ ┣ CreateUserStepDefinition.java
  ┃     ┃ ┃ ┣ DeleteUserStepDefinition.java
  ┃     ┃ ┃ ┣ GetUserByIdStepDefinition.java
  ┃     ┃ ┃ ┗ UpdateUserStepDefinition.java
  ┃     ┃ ┗ RunApiTest.java <- Main class untuk menjalankan test API
  ┃     ┗ webautomationtesting
  ┃       ┣ helper
  ┃       ┃ ┗ Helper.java
  ┃       ┣ hooks
  ┃       ┃ ┗ Hooks.java
  ┃       ┣ pages
  ┃       ┃ ┣ CartPage.java
  ┃       ┃ ┣ CheckoutPage.java
  ┃       ┃ ┣ DashboardPage.java
  ┃       ┃ ┣ DetailProdukPage.java
  ┃       ┃ ┣ LoginPage.java
  ┃       ┃ ┗ MenuPage.java
  ┃       ┣ stepdefinitions
  ┃       ┃ ┣ CartStepDefinition.java
  ┃       ┃ ┣ CheckoutStepDefinition.java
  ┃       ┃ ┣ DashboardStepDefinition.java
  ┃       ┃ ┣ DetailProdukStepDefinition.java
  ┃       ┃ ┣ LoginStepDefinition.java
  ┃       ┃ ┗ MenuStepDefinition.java
  ┃       ┗ RunWebTest.java <- Main class untuk menjalankan test web
  ┗ resources
    ┣ apitesting
    ┃ ┣ features
    ┃ ┃ ┣ create.feature
    ┃ ┃ ┣ delete.feature
    ┃ ┃ ┣ get.feature
    ┃ ┃ ┗ update.feature
    ┃ ┗ schema
    ┃   ┗ user-schema.json
    ┗ webautomationtesting
      ┗ features
        ┣ cart.feature
        ┣ checkout.feature
        ┣ dashboard.feature
        ┣ detailproduk.feature
        ┣ endtoend.feature
        ┣ login.feature
        ┗ menu.feature
target
┣ cucumber-reports-api
┃ ┣ CucumberTimeline
┃ ┣ Cucumber.html
┃ ┣ Cucumber.json
┃ ┗ Cucumber.xml
┗ cucumber-reports-web
  ┣ CucumberTimeline
  ┣ Cucumber.html
  ┣ Cucumber.json
  ┗ Cucumber.xml
pom.xml
README.md
```

# Workflow

Langkah pembuatan test script

1. Buat scenario pengujian pada file feature untuk masing-masing fungsionalitas login dan logout.
2. Buat step definition untuk step-step yang ada pada skenario di masing-masing file feature seperti given, when, then.
3. Import library-library yang dibutuhkan di tiap file step definition, yaitu: cucumber, assertTrue dari JUnit, dan WebDriver dari selenium.
4. Buat method untuk tiap step pada scenario dengan menggunakan notasi-notasi yang sesuai seperti @Given, @When, dsb.

# Software Under test

Pengujian dilakukan untuk web SWAG LABS yang dapat diakses pada https://www.saucedemo.com/ dan API Dummy API yang dapat diakses pada https://dummyapi.io/

- Fitur Login
- Fitur Logout

# Test Case

Pembuatan test case meliputi test positif dan test negatif, yaitu

## Test Case Login

    1. Login dengan username dan password yang terdaftar pada sistem
    2. Login dengan username yang terdaftar dan password tidak sesuai
    3. Login dengan username yang tidak terdaftar
    4. Login dengan username tidak terisi dan password terisi
    5. Login dengan username terisi dan password tidak terisi
    6. Login dengan username dan password tidak terisi

## Test Case Logout

    1. Pengguna logout dari aplikasi

Note. Pendekatan pengujian menggunakan black box testing dengan metode Decision Table.
Satuan unit adalah fitur atau fungsi software

# Author

- Jovan Shelomo
- Mey Meizia Galtiady
- Rahma Alia Latifa
- Kelompok B6 PPL
- Jurusan Teknik Komputer dan Informatika
- Politeknik Negeri Bandung

# Reference

Daftar resource yang dapat dipelajari

- <a href="https://www.saucedemo.com/">Sauce Demo Web</a>
- <a href="https://cucumber.io/docs/cucumber/">Cucumber documentation</a>
- <a href="https://www.selenium.dev/documentation/">Selenium documentation</a>
