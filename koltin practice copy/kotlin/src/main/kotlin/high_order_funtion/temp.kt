import kotlin.concurrent.thread

fun rollDice(callback: ((result: Int) -> Unit)? = null) {
    println("Roll Dice Started")
    thread {
        //mimicking a heavy operation
        //by just putting a Thread.sleep
        Thread.sleep(5000)
        //function was already finished
        //but after 5 seconds
        //we will get a callback at the trailing lambda
        callback?.invoke((1..6).random())
    }
    println("Roll Dice Ended")
}

fun main() {
    rollDice {
        println(it)
    }
}