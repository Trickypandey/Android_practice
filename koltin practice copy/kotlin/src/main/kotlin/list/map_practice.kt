package list
fun bookPair(B_title:String,B_author:String):Pair<String,String> {
    return B_title to B_author
}
fun main() {
    val allBooks= setOf("One Piece","Naruto","Berserk","Dragon Ball","Astro Boy")
    val allAuthor = setOf("Eiichiro Oda","Masahi Kishimoto","Kentaro Miura","Akira Toriyama","Osamu Tezuka")
    var library = mutableMapOf<String,String>()
    var i =0
//    library.put("sou","tric")
    while (i<allBooks.size || i<allAuthor.size){
        library.put(allBooks.elementAt(i),allAuthor.elementAt(i))
        i++
    }
    println(library.toString())
//    library.getOrPut("One piece")
    println(library.keys)
    println(library.get("One Piece"))

}

