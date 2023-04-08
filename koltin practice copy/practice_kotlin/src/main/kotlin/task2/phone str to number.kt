package task
fun toNumber(str:String): String {
    if (str.length!=12){
        return "please enter the number in format of ***-***-****"
    }
        val numLet = mapOf<String,Int>("abc" to 2, "def" to 3, "ghi" to 4,"jkl" to 5,"mno" to 6,"pqrs" to 7,"tuv" to 8,"wxyz" to 9)
        var tempStr :String=""
    str.split("-").forEach {
        try{
            if (it.toInt() is Int) {
                println(it)
                tempStr+= "$it-"
            }
        }
//        catch (e:Exception){
//            println(e.stackTrace)
//        }
        catch (e:Exception){
            println("reached in catch")
            val itr =numLet.keys.iterator()
            while (itr.hasNext()){
                val key = itr.next()
//                println("it=$it and key=$key ")
                for (i in it){
//                        println("i=$i")
//                        println("$i =====$key")
                    if (i in key){
//                        println("$i --------$key")
                        tempStr+=numLet.get(key)
                    }
                }
            }
        }
    }
    println(tempStr)
    return tempStr
}
fun main() {
    println(toNumber("234-234-utfe"))
}