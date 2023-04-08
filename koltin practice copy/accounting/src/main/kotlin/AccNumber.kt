import java.io.BufferedReader
import java.io.DataInput
import java.io.File
import java.io.InputStreamReader
import java.nio.file.attribute.AclEntry.Builder
import java.time.temporal.TemporalAmount
import java.util.ArrayList
import java.util.Scanner
var filepath="C:\\Users\\NK HP\\IdeaProjects\\accounting\\src\\main\\kotlin\\Bank-Account.txt"
fun displayHeading(){
    println("Number\tName\t\tType\t\tInterest Rate\t\tBalance")
}
fun displayAccount(bankAccount: BankAccount) {
    println("${bankAccount.number}\t${bankAccount.name}\t${bankAccount.type}\t\t${bankAccount.interestRate}\t\t\t\t\t${bankAccount.balance}")
}
fun displayAccounts(bankAccounts:List<BankAccount>){
    displayHeading()
    bankAccounts.forEach{
        displayAccount(it)
    }
}
fun deposit(acc_no: Int,amount: Int){
    val file = File(filepath)
    var text = file.readText()
    text.split("\n").forEach{
        var line = it.split(", ")
        var bal=line[4].toInt()
        var checkacc=line[0].substring(1,line[0].length-1).toInt()
        if (line.size>0 && acc_no==checkacc){
            var finalbal = bal + amount
            text=text.replace(bal.toString(),finalbal.toString())
            println("reached")
            return
        }
        else println("please enter a valid account number")
    }
}
fun getBal(acc_no:String){
    val file = File(filepath)
    val text = file.readText()
    text.split("\n").forEach{
        val line = it.split(", ")
        val checkacc=line[0].substring(1,line[0].length-1)

        if (line.size>0 && acc_no==checkacc){
            println("Balance of account ${line[0]} is ${line[4]}")
            return
        }
        else println("please enter a valid account number")
    }
}
fun menu(){
    println("Main Menu:")
    println("Please select an option from the following menu:")
    println("\t 1 = Enter New Accounts")
    println("\t 2 = Check Account Record")
    println("\t 3 = Show Sorted Account List")
    println("\t 4 = get Balance")
    println("\t 5 = Deposit")
    println("\t 0 = Exit")
}
fun numberOfAccount():ArrayList<BankAccount>{
    var bankAccounts = arrayListOf<BankAccount>()
    val file = File(filepath)
    val text = file.readText()
    text.split("\n").forEach {
        val line = it.split(", ")
        if(line.size > 1) {
            val number = line[0].removeSurrounding("\"").toInt()
            val name = line[1].removeSurrounding("\"")
            val type = line[2].removeSurrounding("\"")
            val interestRate = line[3].toDouble()
            val balance = line[4].substring(0, line[4].length - 1).toInt()
            val bankAccount = BankAccount(number, name, type, interestRate, balance)
            bankAccounts.add(bankAccount)
        }
    }
    return bankAccounts
}
fun createAccount(input: BufferedReader):BankAccount{
    println("enter data for new account")
    println("\t Enter Account Number")
    val number = input.readLine().toInt()
    println("\t Enter Name")
    val name = input.readLine();
    println("\t Account Type")
    val type = input.readLine()
    println("\t Interest Date")
    val interestRate = input.readLine().toDouble()
    print("\t • Balance:")
    val balance = input.readLine().toInt()
    val content = "\"$number\", \"$name\", \"$type\", $interestRate, $balance"
//    File(filepath).bufferedWriter().use { out ->
//        out.write(content)}
    File(filepath).appendText("\n"+content)
    return  BankAccount(number,name,type,interestRate,balance)
}
fun main(){
var bankAccounts= numberOfAccount()
    println(bankAccounts)
    menu()
    println("choose your option")
    while (true){
        val input = BufferedReader(InputStreamReader(System.`in`))
        var option=input.readLine().toInt()
        when(option){
            1-> {
                val bankAccount = createAccount(input)
            }
            2->{
                println("enter the account number ro search")
                var number =input.readLine().toInt()
                var bankAccount = bankAccounts.find { it.number == number }
//                println("rechead")
                if(bankAccount != null) {
                    displayHeading()
                    displayAccount(bankAccount)
                }
            }
            3-> {
                bankAccounts.sortBy { it.number }
                displayAccounts(bankAccounts)
            }
            4->{
                println("enter the account number to check the balance ")
                val accnumber = input.readLine().toString()
                getBal(accnumber)
            }
            5->{
//                println("rechead")
                deposit(100015,1000)
            }
            0-> break
            else-> println("choose a valid option")
        }
    }
}