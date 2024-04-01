package com.example.cotlindersim

// overriding conflicts
interface Abc {

    fun callMe()
}

interface Dfg  {
    fun callMe() {
        println("From interface Dfg")
    }
}

class C: Abc, Dfg {
    override fun callMe() {
        super<Dfg>.callMe()  // Abc interface'inin call me methodunu cagırır
    }
}

class D: Abc, Dfg {
    override fun callMe() {
        TODO("Not yet implemented")
    }
}


fun main(args: Array<String>) {
    val obj = C()

    obj.callMe()
}