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

fun main(args: Array<String>) {
    val a = 1
    val b = 8
    val result = sum(a, b).also {
        println(it)
    }

    val result_1 = sum_1(a, b).also { println(it) }
    printSum(a,b)
}