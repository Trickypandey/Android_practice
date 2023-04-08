class Person(firstname: String ="unknown", secondname: String= "UNKNOWN" , age: Int=18){
    var Firstname :String
    var Secondname:String
    val Age :Int

    init {
        Firstname = firstname.capitalize()
        Secondname = secondname.capitalize()
        Age = age

        println("First Name = $Firstname")
        println("Second Name = $Secondname")
        println("Age = $age")
    }
}
fun main(){
    println("person1 is instantiated")
    val person1=Person("sourabh","pandey",22)

    println("person2 is instantiated")
    val person2 = Person("Tricky", age = 31)

    println("person3 is instantiated")
    val person3 = Person()
}