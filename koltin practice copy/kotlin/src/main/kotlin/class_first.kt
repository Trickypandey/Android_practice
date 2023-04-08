class Car{
    private var isOn:Boolean=true

    fun turnOnn(){
        isOn=true
    }

    fun turnOff(){
        isOn= false
    }
    fun displayLightStatus(car:String){
        if (isOn==true){
            println("$car is on")
        }
        else{
            println("$car is of")
        }
    }
}
fun main(){
    val l1 = Car()
    val l2 = Car()
    l1.turnOff()
    l2.turnOnn()

    l1.displayLightStatus("l1")
    l2.displayLightStatus("l2")

}