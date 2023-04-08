import java.io.File

fun main(){
    val file = File("C:\\Users\\NK HP\\IdeaProjects\\accounting\\src\\main\\kotlin\\temp.txt")
    val text = file.readText()
    text.split(" ").forEach {
        print(it.split("/n"))
    }
}