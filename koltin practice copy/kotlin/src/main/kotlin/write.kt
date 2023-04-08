import java.io.File

fun  main(){
    var filepath="C:\\Users\\NK HP\\IdeaProjects\\accounting\\src\\main\\kotlin\\temp.txt"
    val content = "\"100021\", \"tricky\", \"Cheque\", 2.5, 64000"
    File(filepath).bufferedWriter().use { out ->
        out.write(content)}
}