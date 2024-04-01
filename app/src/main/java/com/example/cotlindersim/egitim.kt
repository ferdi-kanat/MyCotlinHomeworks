package com.example.cotlindersim


fun main() {
    val fortune = getFortuneCookie()
    println("Your fortune is: $fortune")
}

fun getFortuneCookie(): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    print("Enter your birthday: ")
    val birthday = readlnOrNull()?.toIntOrNull() ?: 1

    return fortunes[birthday % fortunes.size]
}