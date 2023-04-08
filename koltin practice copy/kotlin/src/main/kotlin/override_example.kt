fun main(){
    val a=sup()
    a.method1()
    a.method2()

    val c :sup=sum()
    c.method2()

    val b=sum()
    b.method1()
    b.method2()
    b.display()
}
open class sup{
    fun method1(){
        println("method one from sup class")
    }
    open fun method2(){
        println("method two from sup class")
    }

}
class sum: sup(){
    override fun method2() {
        println("method two from sum class")
    }
    fun display(){
        println("method display from sup class")
    }
}