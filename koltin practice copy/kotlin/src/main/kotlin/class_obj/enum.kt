package class_obj
// once a instance is created connot be changed
fun main()
{
    val day = DAYS.SATURDAY
    println(day)
    println(day.number)
    for (day in DAYS.values()) {
        println("${day.name}")
    }
    day.dayformatter()
}
enum class DAYS(val number: Int){
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(10);

    fun dayformatter(){
        println("Day is $this")
    }
}