import java.util.Scanner

class Admin{
    private  val password :String= "123456"
    var StdList = ArrayList<Student>()
    var rollNo :Int=5
    val input = Scanner(System.`in`)


    fun PasswordAuthentication(pass:String):Boolean{
        if (pass==password)
            return true
        return false
    }

    fun adminHeading(){
        println("RollNO\t\t Name\t\t Maths \t\t English\t\t Science\t\t percentage")
    }
    private  fun addStdMarks(){
        println("Enter the Student name ")
        val name = readLine().toString()

        println("Enter the Math Marks")
        val mathsMark = input.nextInt().toDouble()
        println("Enter the English marks")
        val englishMark = input.nextInt().toDouble()
        println("Enter the science marks")
        val scienceMark = input.nextInt().toDouble()
        StdList.add(Student(rollNo ,name,englishMark,mathsMark,scienceMark))
        rollNo++
    }
    fun searchStd(rollno:Int): Student? {
        for (i in StdList){
            if (rollno==i.rollNo){
                return i
            }
        }
        return  null
    }
    fun sortStd(){
        StdList.sortBy { it.name }
    }
    fun deleteStd(idx:Student?){
        StdList.remove(idx)
    }
    fun adminMenu(){
        var temp="y"
        StdList.add(Student(1,"Sourabh",70.0,81.0,41.0))
        StdList.add(Student(2,"shivam",77.0,90.0,91.0))
        StdList.add(Student(3,"Navneet",76.0,81.0,81.0))
        StdList.add(Student(4,"Dhannan",80.0,82.0,71.0))
        do {
            println("The menu: ")
            println("1. Add a student and their marks")
            println("2. Show all the student")
            println("3. searching for student")
            println("4. To delete the student")
            println("5. To delete the student")
            println("0. Exit")
            println("Enter your choice: ")
            val i =Integer.valueOf(readln())
            when(i){
                0->{
                    temp="N"
                }
                1->{
                    addStdMarks()
                }
                2->{
                    adminHeading()
                    for (i in StdList){
                        println(i)
                    }
                }
                3->{
                    val search = input.nextInt()
                    if(searchStd(search)!=null){
                        println(searchStd(search))
                    }
                    else{
                        println("please enter a valid roll number")
                    }
                }
                4->{
                    val search = input.nextInt()
                    if(searchStd(search)!=null){
                        deleteStd(searchStd(search))
                        println("Student deleted successfully")
                    }
                    else{
                        println("please enter a valid roll number")
                    }
                }
                5->{
                    sortStd()
                    println(sortStd())
                }
            }
        }while (temp=="y")
    }
}