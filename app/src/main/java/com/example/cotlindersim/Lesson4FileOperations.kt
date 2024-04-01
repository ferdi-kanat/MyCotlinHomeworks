package com.example.cotlindersim


import java.io.File

fun main(){

    //Kotlin - File Operations

    // Yeni dosya oluşturma

    val fileName = "Demo.txt"
    // Create file object
    val file = File(fileName)
    // Create file
    var isCreated = file.createNewFile()
    if (isCreated)
        println("File is created")
    else
        println("File is not created")
    // Again create file
    // Eğer dosya adı mevcut değilse dosya oluşturulup true döner, mevcutsa aynı dosya adı ile oluşturamayıp false döner
    // Dosyalar projenin root dizini içerisinde oluşturulmaktadır

    isCreated = file.createNewFile()
    if (isCreated)
        println("File is created")
    else
        println("File is not created")
    //  file.exists() metodu ile de kontrol edilebilir

    // Dosyaya Yazma

    // writeText() metodunu kullanarak bir dosyaya veri yazabiliriz
    // String'i argüman olarak alır ve onu dosyaya yazar.
    // Belirtilen adda bir dosya yoksa yeni bir dosya oluşturacaktır.
    // Dosya zaten mevcutsa, dosyanın yerini alacaktır .
    // Verilen veriler ilk önce varsayılan olarak UTF-8 karakter seti kullanılarak kodlanır. Ayrıca başka herhangi bir karakter kümesini de belirtebiliriz.


    val fileName2 = "Demo2.txt"
    val file2 = File(fileName2)

    file2.writeText("Hello World")
    file2.writeText("Bye world")
    // Demo.txt dosyasını kontrol edersek içinde sadece Bye world'ü göreceğiz . Bunun nedeni, writeText()dosyada bulunan tüm içeriğin yerini almasıdır.

    // Mevcut verilerin kaybolmasını önlemek istiyorsak appendText() fonksiyonunu kullanabiliriz.
    file2.appendText("\nThe world is yours!")

    // Dosyadan Veri Okuma
    // İçeriği satır satır okumak için forEachLine() yöntemini kullanabiliriz. Dosyadaki verileri satır satır okuyacaktır.
    file2.forEachLine {
        println("line: $it")
    }

    // Bir dosyadan tüm içeriği doğrudan okumak için readText() metodunu kullanabiliriz.
    val data = file2.readText()
    println(data)

    // Yeni bir dizin oluşturma
    //val directory = File("mydata")
    //directory.mkdir()
    println("Directory created successfully.")
    // mydata adında yeni bir dizin oluşturur.
    // dizin mevcutsa yine oluşturulmuş kabul edilir.

    // dosya mevcutluğunu kontrol etme
    //val fileNameCheck = "Demo.txt"
    //var fileNew = File(fileNameCheck)
    //var fileExists = fileNew.exists()

    //if(fileExists){
    //    print("$fileNameCheck exists.")
    // } else {
    //     print("$fileNameCheck does not exist.")
    // }


    // dosya adı öğrenme
    // val aFile = File("path/to/file")
    //aFile.name // dosyanın adını almanızı sağlar

    // dosyayı başka bir dosyaya kopyalama
//    File("file.txt").copyTo(File("target_file.txt"));

    // dosyayı başka bir konuma kopyalama
     val sourceFilePath = "Demo.txt"
     val targetFilePath = "app/Demo.txt"

     val sourceFile = File(sourceFilePath)
     val targetFile = File(targetFilePath)

     try {
        sourceFile.copyTo(targetFile)
         println("$sourceFile is copied to $targetFile")
     } catch (e: Exception) {
         println("Error occurred while copying file.")
       e.printStackTrace()
     }

}