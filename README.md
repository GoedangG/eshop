# ADVPRO - ESHOP
> Rizqi Bayu Utama - 2206826330  Pemrograman Lanjut - B

### [ADVPRO - ESHOP](https://eshop-rbayuu.koyeb.app/)
Aplikasi Eshop dapat diakses pada link diatas ⬆⬆

## TUTORIAL 1
##### REFLEKSI 1 
You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.
1. Menamai variabel-method/function dengan nama yang jelas dan mewakilkan apa yang dikerjakan variabel/method tersebut
2. untuk secure coding, saya menggunakan "POST" method untuk membuat products.

Pada intinya, kedepannya saya akan meluangkan waktu untuk mengoreksi kembali code-code yang sudah saya tulis, mencoba untuk memperbaiki jika ada kesalahan dan juga agar lebih efisien serta clean code.

##### REFLEKSI 2
1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? 
    - jawab: Setelah melakukan unit test, saya merasa bahwa code saya cukup berfungsi secara fungsionalitas. Tidak ada batasan untuk membuat berapa banyak unit test, namun unit test harus meng-cover semua kemungkinan yang ada.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
   What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!
    - Jawab: Membuat kelas baru untuk functional test dapat menjadi pilihan yang baik, namun bisa saja terjadi duplikasi code, potensi dependensi test, dan nama test case yang kurang jelas. Cara yang saya terapkan untuk membuat clean code sebagai berikut:
      - Menamai test case dengan jelas dan deskriptif terhadap apa yang dites.
      - Mengurangi duplikasi code dengan mengambil instance variabel kedalam utility class yang terpisah atau base test class.

## TUTORIAL 2
##### REFLEKSI 
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
   - Menghapus beberapa import yang tidak digunakan
   - Penggunaan nama variabel diusahakan mendeskripsikan apa isi variabel tersebut
   - Menghapus public modifier yang tidak penting
   
2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? 
   - Menurut saya implementasi ci/cd yang sudah saya buat memenuhi definisi dari ci/cd itu sendiri. Hal ini dikarenakan code yang saya buat telah terintegrasi dengan sonarcloud, scorecard dan koyeb yang akan ter-deploy secara otomatis. Menurut saya sendiri itu sudah cukup memenuhi standart yang telah ditetapkan.

## TUTORIAL 3
##### REFLEKSI
1. Explain what principles you apply to your project!
   - Jawab: Salah satu principles yang saya implementasikan dalam code saya adalah `Dependency Inversions Principle (DIP)` dimana `CarServiceImpl` dan `ProductServiceImpl` bergantung dengan interface `CarRepositoryInterface` dan `ProductRepositoryInterface` bukan langsung ke repository. Hal ini dapat secara efektif menambah fleksibilitas code dan pemisahan code yang jelas.

2. Explain the advantages of applying SOLID principles to your project with examples.
   - Jawab: Advantages yang saya dapatkan dengan mengimplementasikan SOLID principles kepada project eshop saya yaitu code saya mudah untuk didevelop untuk kedepannya dan menurut saya pribadi juga terlihat lebih rapih dan mudah dibaca. 
   
3. Explain the disadvantages of not applying SOLID principles to your project with examples.
   - Jawab: Seperti yang saya jelaskan pada nomer 2, ketika tidak mengimplementasikan SOLID principles, code saya jauh lebih sulit dibaca dibandingkan ketika mengimplementasikan SOLID.

## TUTORIAL 4
##### REFLEKSI
1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.
   - Jawab:  Menurut saya sangatlah berguna walaupun sulit untuk diimplementasikan pada saat pertama kali. Sejujurnya saya belum terbiasa untuk membuat testing terlebih dahulu sebelum implementasi class model/repository/dll nya.
   
2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
   - Jawab: Saya sendiri tidak terlalu yakin apakah sudah terimplementasi dengan baik atau belum, karena pada code coverage yang disediakan sonarcloud pun saya belum mencapai 100%.