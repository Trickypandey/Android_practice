fun main()
{
    var ch = 'Y'
    val a = Admin()

    do
    {
        println("The menu: ")
        println("1. Login as admin")
        println("2. Login as student")
        println("3. Exit")
        println("Enter your choice: ")
        val i = Integer.valueOf(readlnOrNull())
        when (i) {
            1 -> { println("1. Enter password")
                val check = readlnOrNull()
                if (check?.let { a.PasswordAuthentication(it) } ==true)
                {
                    a.adminMenu()
                }
                else{
                    println("You entered the wrong password!")
                }}
            3 -> {ch='N'}
            else -> {
                print("Wrong choice entered!")
            }
        }
        println("Do you want to continue? Enter Y if yes else press any key: ")
        ch = (readLine()!![0])
    } while (ch=='Y')
}

