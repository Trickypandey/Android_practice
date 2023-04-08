package task2


fun primeNumber(num: Int): Boolean {
    var flag = true
    for (i in 2..num / 2) {
        if (num % i == 0) {
            flag = false
            break
        }
    }
    return flag
}
fun displayAllPrime(n: Int){
    var low =2
    while (low < n) {
        if (primeNumber(low))
            print(low.toString() + " ")
        ++low
    }
}
fun main(){
    val n=10
    displayAllPrime(n)

}