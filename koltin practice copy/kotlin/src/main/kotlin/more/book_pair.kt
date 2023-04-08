package more

import java.time.Year

class Book(var title:String,author:String,year: Int){

//    var B_title:String=""
//    var B_author:String=""
//    var B_year:Int=0
    var B_title=title
    var B_author=author
    var B_year=year


    fun bookPair():Pair<String,String>{
        return title to B_author
    }
    fun bookTriple():Triple<String,String,Int>{
        return Triple(B_title,B_author,B_year)
    }
}
fun main() {
    val book1 = Book("ONE PIECE","Eiichiro Oda",1977)
    println("Here is the ${book1.bookPair().first}written by ${book1.bookPair().second}")
    println("Here is the ${book1.bookTriple().first}written by ${book1.bookTriple().second} in ${book1.bookTriple().third}")
}