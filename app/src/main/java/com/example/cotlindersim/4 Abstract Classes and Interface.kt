package com.example.cotlindersim


// Abstraction nedir?
 /**
 Farklı kod parçalarının kompleks kısımlarını,sahip oldukları ortak davranışlar, amaçlar,
 karakteristik özellikler arkasında saklamak sayesinde daha anlaşılır ve kolay kullanılabilir kod yazmaktır abstraction.

 Blueprint'tir (TASLAK)

 Abstract sınıfları genel olarak inheritance (kalıtım) uygularken kullanırız.
 nesneleri oluşturulamaz.
 İçerisinde değişken ve metod bulundurabilir.
 Abstract sınıflardan türetilen sınıfların abstract metodları implement etmesi zorunludur. Diğer metodları override etmeden de kullanabilir.
 Constructors (yapıcı metodlar) ve destructors (yıkıcı metodlar) bulundurabilirler.
 Static tanımlanamazlar. ( Tanımlanmaya çalışılırsa compiler “an abstract class cannot be sealed or static” hatası verir)
 Bir sınıf yalnızca bir abstract sınıfı inheritance yoluyla implement edebilir. Çoklu kalıtım (multiple inheritance) desteklenmez.
 Abstract olmayan metodları da bulundurabilir.
 Kendisinden inherit alacak sınıflar ile arasında “is-a” ilişkisi vardır.

  Cat is an animal
*/

// Abstract classlardan nesne üretemezsiniz
abstract class Person2(name: String) {

    var age: Int = 40
    fun displaySSN(ssn: Int) {
        println("My SSN is $ssn.")
    }

    abstract fun displayJob(description: String)
}

class Teacher(name: String): Person2(name) {

    var fName : String

    init{
        fName = name
    }

    override fun displayJob(description: String) {
        println(description)
    }
}


abstract class Employee(val name: String, val experience: Int, open val dateOfBirth: Int) {

    abstract val fname : String
    abstract val jobExperience : Int

    abstract fun getDateOfBirthFormatted(): String

    fun printDetails() {
        println("Name:$name")
        println("Experience:$experience")
        println("Employee birthday message:${getDateOfBirthFormatted()}")
    }
}

class SoftwareEngineer(name: String, experience: Int, override val dateOfBirth: Int) : Employee(name, experience, dateOfBirth) {
    override val fname: String
        get() = name
    override val jobExperience: Int
        get() = experience

    override fun getDateOfBirthFormatted(): String {
        return "println($dateOfBirth)"
    }
}

class TestEngineer(name: String, experience: Int, override val dateOfBirth: Int) : Employee(name, experience, dateOfBirth) {
    override val fname: String
        get() = name
    override val jobExperience: Int
        get() = experience

    override fun getDateOfBirthFormatted(): String {
        return "testing v1:$dateOfBirth"
    }
}

fun main() {
  val softwareEngineer= SoftwareEngineer("musa",40,62)
    softwareEngineer.printDetails()


    val testEngineer= TestEngineer("isa", 14, 86)
   testEngineer.printDetails()
}



