package org.demos.functions

/*
  Kotlin functions are first class means they can be stored in variables and data structures,
  passed as a arguments and returned from other higher order functions.

  A higher order function is a function that takes functions as parameter or returns a function.
*/

fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}


fun main() {
    val items = listOf(1, 2, 3, 4, 5)

    items.fold(0, { acc: Int, i: Int ->
        println("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // last expression in lambda is the return value
        result
    })

    // Parameter types in lambda are optional if they can be inferred
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
    println(joinedToString)
    val product = items.fold(1, Int::times)
    println(product)

    /*
       A value of a function type can be invoked by using invoke(...) operator: f.invoke(x) or just f(x)
    */
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus
    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))
    println(intPlus.invoke(1, 2))
    println(intPlus(1, 1))
    println(2.intPlus(3)) // extension like call

}