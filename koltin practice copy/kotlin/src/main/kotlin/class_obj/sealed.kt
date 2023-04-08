package class_obj
// in the case od sealed class we restrict the type
// multiple type so it have multiple objects and multiple state
fun main() {
    val  tile:Tile = red("bean",5)
    val tile2:Tile=blue(20)

    val point = when(tile2){
        is blue -> tile2.point*2
        is red -> tile2.point*5
    }
    println(point)
}
 sealed class Tile
     class  red(val type:String, val point:Int) : Tile()
     class  blue(val point: Int):Tile()