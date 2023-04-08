package class_obj

class User(nameParam: String, ageParam: Int, emailParam: String)
{
    var name : String = nameParam
    var age: Int = ageParam
        set(value) {
            if(value < 0)
            {
                println("Age can't be negative")
            }
            else
            {
                field = value
            }
        }
    var email: String = emailParam
}
fun main() {
    val user = User("John", 20, "Sourabh.com")
    println(user.email)
    println(user.age)
    println(user.name)

}

