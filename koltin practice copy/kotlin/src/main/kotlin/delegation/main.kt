package delegation
interface Engine{
    fun runOn()
    fun carType()
}
class ElectricEngine:Engine{
    override fun runOn() {
        println("this is a electric engine")
    }

    override fun carType() {
        println("this is a sports car")
    }
}
// without delegate
//class TeslsEngine(val engine:Engine){
//    fun runOn(){
//        engine.runOn()
//    }
//}

// with delegate
class TeslsEngine(val engine: Engine):Engine by engine{
    override fun carType() {
        println("not applicable")
    }
}
fun main() {
    val temp = TeslsEngine(ElectricEngine())
    temp.runOn()
    temp.carType()
}