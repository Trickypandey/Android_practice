package class_obj
class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

fun copyAddress(address: Address):Address{
    val result =Address()
    result.name=address.name
    result.street = address.street
    result.city = address.city
    result.state = address.state
    result.zip = address.zip
    return result
}

fun main() {
//    copyAddress()
    val temp = Address()
    temp.name="sourabh"
    println(temp)
}
