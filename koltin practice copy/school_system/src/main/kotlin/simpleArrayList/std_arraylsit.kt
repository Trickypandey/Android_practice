//package simpleArrayList
//
//import Student
//import java.util.Scanner
//
//fun main() {
//    val input = Scanner(System.`in`)
//    val list =ArrayList<Student>()
//    val s1 = Student("Sourabh",70.0,81.0,41.0)
//    val s2 = Student("shivam",77.0,90.0,91.0)
//    val s3 = Student("Navneet",76.0,81.0,81.0)
//    val s4 = Student("Dhananajay",80.0,82.0,71.0)
//    println("Adding in the list")
//    list.add(s1)
//    list.add(s2)
//    list.add(s3)
//    list.add(s4)
//    list.add(Student("vishal",100.0,100.0,100.0))
////    println(list[0].toString())
//
//    println("updating student")
////    list[0].name="Tricky"
//// list before changing the maths marks
////    println(list[0].toString())
//    for (i in list){
//        println("${i.name} = ${i.mathsM}")
//    }
//
//    println("lets update the Math marks of all students")
////    println(list[0].toString())
//    for (i in list){
//        i.mathsM=input.nextDouble()
//    }
//// list after changing the maths marks
//    for (i in list){
//        println("${i.name} = ${i.mathsM}")
//    }
//
//}