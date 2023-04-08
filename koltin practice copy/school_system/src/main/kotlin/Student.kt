data class Student(var rollNo:Int,var name:String , var englishM:Double,var mathsM:Double,var scienceM:Double) {
    private var percentage:Double=(mathsM+englishM+scienceM)/3
    override fun toString(): String {
        return ("$rollNo\t\t $name\t\t $mathsM\t\t $englishM\t\t $scienceM\t\t $percentage")
    }
}