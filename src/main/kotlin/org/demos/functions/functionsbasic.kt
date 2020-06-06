package org.demos.functions

// basic fun with return type Int
fun sum(a: Int, b: Int): Int {
    return a + b
}

// function with inferred return type
fun sum_1(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}


// Member function is a function defined inside a class or object
class Sample {
    open fun foo() {
        println("inside foo")
    }
}

/*
       Kotlin supports style of functional programming known as tail recursion
       some algorithms can be written using recursion rather than traditional style without the risk of stack overflow
       To be eligible for tailrec modifier a function must call itself as the last operation it performs.
       u cannot use tailrec within try/catch/finally blocks
       tailrec modifier supported in Kotlin for JVM and Kotlin/Native
    */

// traditional style
val eps = 1E-10 // could be 10^-15
private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}

// Using tail recursion - fast and efficient loop
val epsilon = 1E-10
tailrec fun findFixPointFast(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < epsilon) x else findFixPointFast(Math.cos(x))


fun main(args: Array<String>) {
    val a = 1
    val b = 8
    val result = sum(a, b).also {
        println(it)
    }

    val result_1 = sum_1(a, b).also { println(it) }
    printSum(a, b)
    val list = asList(1, 2, 3)
    println(list)
    val arr = arrayOf(1, 2, 3)
    val l = asList(-1, 0, *arr, 4) // use of spread operator
    println("new list = $l")
    val x = findFixPoint()
    println(x)
    val ans = findFixPointFast()
    println(ans)

}

// variable no of arguments(varargs), parameter of a function, normally the last one marked as a vararg
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an array
        result.add(t)
    return result
}






