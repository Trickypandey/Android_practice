fun main(){
    // can lable loop and break a loop as required with lable break ]
    first@ for(i in 1..4){

        second@ for (j in 1..4)
        {
            println(" i = $i and j = $j")

            if (j==2)
//                break@first
                break@second
        }
    }

}