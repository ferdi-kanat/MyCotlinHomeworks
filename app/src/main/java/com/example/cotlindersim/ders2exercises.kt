package com.example.cotlindersim

fun main(){

    main2()
    println("welcome to my calculator")

    print("give me first operand for calculate: ")
    var numberOne = readln().toInt()
    println(" your first number is: $numberOne")

    print("give me second operand for calculate: ")
    var numberTwo:Int = readln().toInt()
    println(" your second number is: $numberTwo")

    //if the second number is equal to 0. this is the number zero exception
    while(numberTwo == 0) {
        print("your second number can not be 0, give another number: ")
        numberTwo = readln().toInt()
    }

    var result :Int? = null
    println("type the operation you want to do(plus, minus, times, div, rem)")
    when(readln().lowercase()){
    "plus" -> result = numberOne.plus(numberTwo)
    "minus" -> result = numberOne.minus(numberTwo)
    "times" -> result = numberOne.times(numberTwo)
    "div" -> result = numberOne.div(numberTwo)
    "rem" -> result = numberOne.rem(numberTwo)
    else -> print("invalid operator")
    }

    print("your result is: $result")
}

    fun main2(){
        val firstArray = arrayOf<Int>(1,2,3,4,5)
        val secondArray = arrayOf<Double>(3.0,4.0,5.0,5.2,6.9)
        var resultArray = Array<Double>(firstArray.size){
            firstArray[it].toDouble() + secondArray[it]
        }
        println("intArray : ${resultArray.joinToString()}")
    }