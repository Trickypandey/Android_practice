package array

import java.util.*

fun main(args: Array<String>) {
    val dates = mutableListOf(
        Date(2020, 4, 3),
        Date(2021, 5, 16),
        Date(2020, 1, 29)
    )

    println("--- ASC ---")
    dates.sortBy { it.date }
    dates.forEach { println(it) }
}