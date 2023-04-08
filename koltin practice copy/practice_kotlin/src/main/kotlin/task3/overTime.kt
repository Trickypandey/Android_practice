package task3

fun round(input: Double): Long {
    val i = Math.ceil(input).toLong()
    return (i + 99) / 100 * 100
}
fun amount(time:Int,hourly:Int,over:Float):Long{
    val temp=time*hourly*over
    return round(temp.toDouble())
}
fun amount(time:Int,hourly:Int): Long {
    val temp =time*hourly
    return round(temp.toDouble())
}
fun calculate(array: FloatArray): Long {
    var office:Long=0
    var overTime:Long=0
    if (array[1]-array[0]>8){
        office=amount((array[1]-array[0]).toInt(),array[2].toInt(),array[3])
    }else{
        overTime=amount((array[1]-array[0]).toInt(),array[2].toInt())
    }
    return office+overTime
}
fun main() {
    val array= floatArrayOf(9f,17f,30f,1.5f)
    println(calculate(array))
}