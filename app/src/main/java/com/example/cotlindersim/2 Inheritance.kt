package com.example.cotlindersim


// Inheritance
// Üst class'lar sahip olduğu tüm özellikleri child classlara iletir.
// child classlara inildikçe özellikler artar
// üst classlar child classlardan daha performanslı çalışır
// Karmaşıklıklar kolay yönetilebilir
// üst classların sahip oldukları yetkinlikleri alt classta değiştirmek isteyeceksiniz, bunu yönetebilirsiniz (Override)


// open : Javada her classı parent class olarak miras alabilirsiniz Javada tüm classlar default olarak open
// Kotlinde ise miras alınacak classın önüne open koymanız gerekiyor. Kotlinde ise tüm classlar default olarak final

// open ve final access modifiers
open class Person(age: Int, name: String) {
    init {
        println("My name is $name.")
        println("My age is $age")
    }

    open fun displayAge(age: Int) {
        println("My age is $age.")
    }

    fun toplam() : Int {
        return 10
    }

}

class MathTeacher(age: Int, name: String): Person(age, name) {
    val fname : String
    var personAge : Int

    init {
        fname = name
        personAge = age
    }

    fun teachMaths() {
        println("I teach in primary school.")
    }
    // Override base function
    override fun displayAge(age: Int) {  // POLYMORPHISM
        println("My fake age is ${age - 10}.")
    // Calling base class's function using super
        super.displayAge(age)
    }

}

class Footballer(age: Int, name: String): Person(age, name) {
    fun playFootball() {
        println("I play for LA Galaxy.")
}
}

fun main() {
    val teacher = MathTeacher(25, "Jack")
    teacher.teachMaths()
    teacher.displayAge(31)
    println(teacher.fname)
    println(teacher.personAge)

    println()

    val footballer = Footballer(29, "Christiano")
    footballer.playFootball()
}