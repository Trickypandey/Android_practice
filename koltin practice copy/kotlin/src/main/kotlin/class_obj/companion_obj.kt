package class_obj

fun main() {
   Outterclass.myObject.temp()
    Outterclass.print()
}

class Outterclass{
    // singleton object have is a relation
    object myObject {
        fun temp() {
            println("i am the output from my object class and singleton object in")
        }
    }

    companion object  temp{
        fun print(){
            println("amas dfkasjd fbas df asjkdfasdbf")
        }
    }
}