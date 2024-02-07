# Rizqi Bayu Utama
# 2206826330
# Pemrograman Lanjut - B

## TUTORIAL 1
## REFLEKSI 1 
You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.
1. Menamai variabel-method/function dengan nama yang jelas dan mewakilkan apa yang dikerjakan variabel/method tersebut
2. untuk secure coding, saya menggunakan "POST" method untuk membuat products.

Pada intinya, kedepannya saya akan meluangkan waktu untuk mengoreksi kembali code-code yang sudah saya tulis, mencoba untuk memperbaiki jika ada kesalahan dan juga agar lebih efisien serta clean code.

## REFLEKSI 2
1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? 
    - jawab: Setelah melakukan unit test, saya merasa bahwa code saya cukup berfungsi secara fungsionalitas. Tidak ada batasan untuk membuat berapa banyak unit test, namun unit test harus meng-cover semua kemungkinan yang ada.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
   What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!
    - Jawab: Membuat kelas baru untuk functional test dapat menjadi pilihan yang baik, namun bisa saja terjadi duplikasi code, potensi dependensi test, dan nama test case yang kurang jelas. Cara yang saya terapkan untuk membuat clean code sebagai berikut:
      - Menamai test case dengan jelas dan deskriptif terhadap apa yang dites.
      - Mengurangi duplikasi code dengan mengambil instance variabel kedalam utility class yang terpisah atau base test class.