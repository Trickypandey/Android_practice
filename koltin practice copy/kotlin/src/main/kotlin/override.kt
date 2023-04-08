fun main(){
    val motorola = Motorola()
    println(motorola.name)
    motorola.diplay()

    val gm = Mobile()
    gm.diplay()
    println(gm.name)
    gm.calling()
    gm.poweroff()

}
open  class Mobile{
    open val name : String="mobile phone"
    open val size : Int =10
    fun calling() = println("calling started")
    fun poweroff()= println("power turn off")
    open fun diplay()= println("this is display of mobile")

}
class Motorola:Mobile(){
    override val name: String="Motorola"
    override val size: Int = 40
    override fun diplay() = println("i am display of Motorola phone")
}