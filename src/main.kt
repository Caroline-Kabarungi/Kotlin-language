fun main(){
    var currentaccount=CurrentAccount("50100","Risper",1000.00)
    currentaccount.deposit(100.00)
    currentaccount.withdraw(500.00)
    currentaccount.details()
    var savingaccount=Savingaccount("1020","Kabarugi",2000.0,2)
    savingaccount.withdraw(200.0)
    productcategory(Product("Geisha",2,100,"hygiene"))
    productcategory(Product("beans",20,500,"groceries"))
    var x= evenindeces("banana")
    println(x)
}
open class CurrentAccount(var accountnumber:String,var accountname:String,var balance:Double){
    fun deposit(amount:Double){
        balance+=amount
        println(balance)
    }
    open fun withdraw(amount: Double){
        balance-=amount
        println(balance)
    }
    fun details(){
        println("Account number $accountnumber with balance $balance is operated by $accountname")
    }
}
class Savingaccount(accountnumber: String,accountname: String,balance: Double ,var withdrawal:Int):CurrentAccount(accountnumber,accountname,balance){
    override fun withdraw(amount: Double) {
        if (withdrawal < 4) {
            withdrawal++
            super.withdraw(amount)
            println("You're able to withdraw")
        } else {
            println("Failed to withdraw")
        }
    }
}
data class Product(var name:String,var weight:Int,var price:Int,var category:String)
fun productcategory(product: Product){
    var groceries= mutableListOf<Product>()
    var hygiene= mutableListOf<Product>()
    var other= mutableListOf<Product>()
    when(product.category){
        "groceries" -> groceries.add(product)
        "hygiene" -> hygiene.add(product)
        else -> other.add(product)
    }
    println(hygiene)
    println(groceries)
}
fun evenindeces(fruits:String):String{
    val fruit=fruits.filterIndexed{ index, c -> index%2==0 }
    return fruit

}