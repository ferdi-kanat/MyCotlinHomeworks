package com.example.cotlindersim



/**
nesneleri oluşturulamaz.
Bir sınıfın ne yapması gerektiğini belirtir, nasıl yapması gerektiğini değil.
Bir sınıf birden fazla interface’i inherit edebilir, çoklu kalıtım (multiple-inheritance) desteklenir.
İçerisinde yalnızca metodların imzaları yer alır, içi dolu metod bulunduramazlar.
Kendisinden inherit alacak sınıflar ile arasında “can-do” ilişkisi vardır. */


// Implementing Two or More Interfaces in a Class
interface A {

    fun callMe() {
        println("From interface A")
    }
}

interface B  {
    fun callMeToo() {
        println("From interface B")
    }
}

// implements two interfaces A and B
class Child: A, B

fun main(args: Array<String>) {
    val obj = Child()

    obj.callMe()
    obj.callMeToo()
}