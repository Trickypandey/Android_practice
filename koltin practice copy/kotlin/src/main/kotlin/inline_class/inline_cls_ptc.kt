package inline_class

inline class Distance(val value: Int)
inline class Time(val value: Int)

class Speed(val distance: Distance,val time: Time)
{
    fun findSpeed():Float{
        return distance.value/time.value.toFloat()
    }
}

fun main() {
    val dis = Distance(120)
    val time=Time(50)

    var speed=Speed(dis,time)

    println(speed.findSpeed())
}