package com.example.cotlindersim

open class   Item(var name : String, var price : Double)

class Food(name: String, price: Double, var weight : String) : Item(name, price)

class Cloth(name: String, price: Double, var type : String) : Item(name, price)

class ShoppingList{
    private var list = mutableListOf<Item>()
    fun addItem(){

        print("Enter the item type you want to add (1 for Food, 2 for Cloth : ")
        when (readln().toInt()) {
            1 -> {
                print("Enter the item name you want to add: ")
                val foodName = readln()
                print("Enter the item price you want to add: ")
                val foodPrice = readln().toDouble()
                print("Enter the item weight you want to add: ")
                val foodWeight = readln()
                list.add(Food(foodName,foodPrice, foodWeight))
                println("$foodName is added successfully!")
            }
            2 -> {
                print("Enter the item name you want to add: ")
                val clothName = readln()
                print("Enter the item price you want to add: ")
                val clothPrice = readln().toDouble()
                print("Enter the item type you want to add: ")
                val clothType = readln()
                list.add(Cloth(clothName,clothPrice, clothType))
                println("$clothName is added successfully!")
            }
            else -> {
                println("Invalid number.")
                addItem()
            }
        }
    }

    fun displayItem(){
        list.forEachIndexed { index, item ->
            if(item is Food) {
                println("${index + 1}. ${item.name} , ${item.price}$, ${item.weight}kg")
        }
            if(item is Cloth) {
                println("${index + 1}. ${item.name} , ${item.price}, ${item.type}")        }
    }}

    fun deleteItem(){
        print("Enter the item name you want to delete:")
        val item = readln()
        for (i in list){
            if(item == i.name) {
                list.remove(i)
                println("$item is deleted successfully! ")
                break
            }
        }
    }

}


fun main(){
    println("***** Welcome to Shopping List App *****")

    val shoppingList = ShoppingList()
    while (true){
        println("Make your choice: (1-2-3-4)")
        println("1. Add Item")
        println("2. Display Item")
        println("3. Delete Item")
        println("4. Exit")
        print("Your choice is: ")
        val choice = readln().toInt()
        if(choice ==1) shoppingList.addItem()
        else if (choice == 2) shoppingList.displayItem()
        else if (choice == 3) shoppingList.deleteItem()
        else if (choice == 4){
            println("Exiting...")
            break
        }
        else println("Wrong choice. Try again")
    }
}