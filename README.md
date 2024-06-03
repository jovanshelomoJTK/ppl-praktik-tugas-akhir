# Project Web Automation Testing & API Testing

Program automation testing ini berfokus pada pengujian API dan Web Application. Program ini menggunakan bahasa Java untuk pembuatan script test dan Maven sebagai build tools. Pengujian dilakukan menggunakan berbagai dependency dan plugin untuk memastikan fungsionalitas API dan Web Apllication berjalan dengan baik.

Terdapat 2 pengujian pada program, diantaranya:
API Testing untuk menguji API User Controller pada tautan https://dummyapi.io/ menggunakan Rest Assured dan Cucumber, dan
Web Testing untuk menguji berbagai fitur dan end to end pada web SWAG LABS dengan tautan https://www.saucedemo.com/ menggunakan Selenium dan Cucumber

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
- com.ppl.apitesting.helper: Berisi kelas `Helper` yang menyediakan fungsi pendukung untuk pengujian API.
- com.ppl.apitesting.hooks: Berisi kelas `Hooks` yang mengatur kondisi awal dan akhir untuk pengujian API.
- com.ppl.apitesting.stepdefinitions: Berisi kelas-kelas `StepDefinition` yang mendefinisikan langkah-langkah pengujian API untuk berbagai operasi (create, delete, get, update).
- com.ppl.apitesting: Berisi kelas `RunApiTest` untuk menjalankan semua tes API.
- com.ppl.webautomationtesting.helper: Berisi kelas `Helper` yang menyediakan fungsi pendukung untuk pengujian web.
- com.ppl.webautomationtesting.hooks: Berisi kelas `Hooks` yang mengatur kondisi awal dan akhir untuk pengujian web.
- com.ppl.webautomationtesting.pages: Berisi kelas-kelas yang merepresentasikan halaman web (CartPage, CheckoutPage, DashboardPage, DetailProdukPage, LoginPage, MenuPage).
- com.ppl.webautomationtesting.stepdefinitions: Berisi kelas-kelas `StepDefinition` yang mendefinisikan langkah-langkah pengujian web untuk berbagai skenario (cart, checkout, dashboard, detail produk, login, menu).
- com.ppl.webautomationtesting: Berisi kelas `RunWebTest` untuk menjalankan semua tes web.
- apitesting.features: Berisi file-file `.feature` untuk mendefinisikan skenario pengujian API (create, delete, get, update).
- apitesting.schema: Berisi skema JSON (`user-schema.json`) untuk validasi data API.
- webautomationtesting.features: Berisi file-file `.feature` untuk mendefinisikan skenario pengujian web (cart, checkout, dashboard, detail produk, end-to-end, login, menu).
- target.cucumber-reports-api: Menyimpan laporan hasil pengujian API dalam berbagai format (Timeline, HTML, JSON, XML).
- target.cucumber-reports-web: Menyimpan laporan hasil pengujian web dalam berbagai format (Timeline, HTML, JSON, XML).

# Workflow

Langkah pembuatan test script

1. Buat scenario pengujian pada file feature untuk masing-masing fungsionalitas untuk api testing dan web testing.
2. Buat step definition untuk step-step yang ada pada skenario di masing-masing file feature seperti given, when, then.
3. Import library-library yang dibutuhkan di tiap file step definition, yaitu: cucumber, assertTrue dari JUnit, dan WebDriver dari selenium.
4. Buat method untuk tiap step pada scenario dengan menggunakan notasi-notasi yang sesuai seperti @Given, @When, dsb.

# Software Under test

SWAG Labs
SWAG Labs merupakan aplikasi e-commerce yang menyediakan fitur login, dashboard, cart, checkout, detail produk, dan navigasi bar yaitu menu. Aplikasi SWAG Labs ini dapat diakses pada link https://www.saucedemo.com/, namun aplikasi ini belum final dan masih ada beberapa keterbatasan. 

User Controller
Program dapat diakses pada link https://dummyapi.io/user dan dapat digunakan untuk menguji API untuk masing HTTP method yaitu GET, POST, PUT, dan DELETE. Pada program ini sudah tersedia daftar user yang tersimpan. Pengujian yang dilakukan adalah API untuk get user by id, create user, update user, dan delete user.

# Test Case

Pembuatan test case meliputi test positif dan test negatif, yaitu

## Pengujian API Testing dilakukan untuk setiap endpoint dengan rincian sebagai berikut:

    5 Test Case untuk endpoint Get User by id
    5 Test Case untuk endpoint Create User
    5 Test Case untuk endpoint Update User
    5 Test Case untuk endpoint Delete User

## Pengujian Web Testing dilakukan untuk setiap halaman dengan rincian sebagai berikut:

    3 Test Case untuk halaman Login
    3 Test Case untuk halaman Dashboard
    3 Test Case untuk halaman Menu
    3 Test Case untuk halaman Detail Produk
    3 Test Case untuk halaman Cart
    3 Test Case untuk halaman Checkout
    1 Test Case untuk pengujian end to end

Note. Pendekatan pengujian dilakukan dengan menggunakan black box testing. untuk pengujian API User Controller, dilakukan dengan metode ECP dan BVA, sedangkan untuk pengujian Web SWAG Labs dilakukan menggunakan metode ECP,BVA, dan Decision Table.
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

- <a href="https://dummyapi.io/user">User Controller</a>
- <a href="https://www.saucedemo.com/">Sauce Demo Web</a>
- <a href="https://cucumber.io/docs/cucumber/">Cucumber documentation</a>
- <a href="https://www.selenium.dev/documentation/">Selenium documentation</a>
- <a href="https://rest-assured.io/">Rest Assured documentation</a>
