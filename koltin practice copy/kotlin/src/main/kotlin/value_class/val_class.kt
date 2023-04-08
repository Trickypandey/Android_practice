package value_class

import array.temp


@JvmInline
value class speed (val spd:Float)
{
    companion object{
        fun speedKM(hr: Int,dis: Int)=speed((dis/hr).toFloat())
        fun speedms(hr: Int,dis: Int)= speed((dis/hr*0.277778).toFloat())
    }

}
fun displaySpeed(message: String, temp: speed) {
    println("$message is ${temp.spd}")
    println("Hashcode of the time period ${temp.hashCode()}")
}

fun main() {
    displaySpeed("your speed is ", speed.speedKM(2,200))
    displaySpeed("your speed is ", speed.speedms(2,200))
}