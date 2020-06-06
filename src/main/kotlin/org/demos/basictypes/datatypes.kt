package org.demos.basictypes

import java.lang.Integer.parseInt

// kotlin provides a set of built in types that represents numbers
/*
   Byte    8bits  -128    127
   Short   16     -32768  32767
   Int     32     -2,147,483,648(-2^31)  2,147,483,647(2^31 - 1)
   Long    64       -2^63             2^63 - 1
 */

val one = 1 //Int
val threeBillion = 3000000000 //Long
val oneLong = 1L //Long
val oneByte: Byte = 1

val pi = 3.14 //Double
val e = 2.7182818284 //Double
val eFloat = 2.7182818284f //Float, actual value is 2.7182817

/*
   Note unlike some language, there are no implicit widening conversions for numbers in kotlin.
   function with Double parameter can be called only on Double values but not Float,Int or other numeric values
 */

fun main() {
    fun printDouble(d: Double) {
        print(d)
    }

    val i = 1
    val d = 1.1
    val f = 1.1f
    printDouble(d)
    //printDouble(i) // Type mismatch
    //printDouble(f) // Type mismatch
}

// Underscores in numeric literals(Since 1.1)
val oneMillion = 1_000_000
val hexBytes = 0xFF_EC_DE_5E

val l = 1L + 3 // Long + Int -> Long


// Conditional expressions
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// In kotlin, if can also be used as an expression
fun maxOfExpression(a: Int, b: Int) = if (a > b) a else b

// Nullable values and null checks
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls
    if (x != null && y != null) {
        println("Product is = ${x * y}")
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

/*
 Type checks and automatic casts
 - `is` operator checks if an expression is an instance of a type
 - If an immutable local variable or property is checked for a specific type, there is no need to cast it explicitly
 */

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }
    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

// when expression
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }


fun main(args: Array<String>) {
    println("eFloat = $eFloat")
    val a: Int = 10000
    val b = 1000
    val p: String = 18.toString()
    val q: String = 20.toString()
    println(a === a) //prints true
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA)  //prints False means does not necessarily preserves identity
    println(boxedA == anotherBoxedA) //prints true means preserves equality

    val maxValue = maxOf(a, b)
    println("maxValue = $maxValue")

    val maxValueEx = maxOfExpression(a, b)
    println("maxValueExpression = $maxValueEx")

    printProduct(p, q)
    var out = getStringLength("Learn kotlin, it's easy to get started")
    println(out)

    // for loop
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    // use of index
    val fruits = listOf("apple", "banana", "kiwifruit")
    for (index in fruits.indices) {
        println("fruit at $index is ${fruits[index]}")
    }

    //while loop
    val lt = listOf("apple", "banana", "kiwifruit")
    var idx = 0
    while (idx < lt.size) {
        println("item at $idx is ${lt[idx]}")
        idx++
    }

    val out1 = describe(1)
    println(out1)
    val out2 = describe(2L)
    println(out2)

    // check if number is within a range using in operator
    val a1 = 10
    val a2 = 9
    if (a1 in 1..a2 + 1) {
        println("fits in range")
    }

    // check if number is out of range
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    // iterating over a range
    for (x in 1..5) {
        print(x)
    }
    println()

    // iterating over string
    for (ch in "abc") {
        print(ch + 1)
    }

}

// smaller types cannot be assigned to bigger unless explicitly widened or converted
val b: Byte = 1
val a: Int = b.toInt()



