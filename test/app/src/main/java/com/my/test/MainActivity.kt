package com.my.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var t1:Int=5
    var t2:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1:Button
        btn1=findViewById(R.id.btn);
        btn1.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"245",Toast.LENGTH_SHORT).show()
        })


        for(i in 1..5)
        {
            for (j in 1..i)
            {
                print(j)
            }
            println()
        }
        println("\n")
        for(i in 1..5)
        {
            var count:Int=1
            for(j in 5 downTo i)
            {
                print(count)
                count++
            }
            println()
        }
       // var  c=A("Hello")
        //Toast.makeText(applicationContext,c.toString(),Toast.LENGTH_SHORT).show()
/*

var ans = when (t1)
{
    1 -> "1"
    2 -> "2"
    3 -> "3"
    4-> "4"
    5 -> "5"
    6 -> "6"
    7 -> "7"
    else -> "20"
}

        Toast.makeText(applicationContext,ans,Toast.LENGTH_SHORT).show()

*/

        /*for (num in 'a'.rangeTo('z'))
        {
            if(num.equals('r'))
            {
                continue
            }
            Log.d("1",num.toString())
           // Toast.makeText(applicationContext,num.toString(),Toast.LENGTH_SHORT).show()

        }*/
        /*for (num in 1..10)
        {

            // Toast.makeText(applicationContext,num.toString(),Toast.LENGTH_SHORT).show()
            if(num%2==0)
            {
                Log.d("1",num.toString())
                t1++
            }
            else
            {
                Log.d("2",num.toString())
                t2++
            }
        }
        Toast.makeText(applicationContext,"$t1,$t2",Toast.LENGTH_SHORT).show()
        val ans=if(t1>6) "six" else "five"
        Toast.makeText(applicationContext,"$ans",Toast.LENGTH_SHORT).show()
*/


/*        my()
        my1("hello")
        Toast.makeText(applicationContext,""+my2("hello"),Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext,""+sum(10,20),Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext,""+multiply(20,30),Toast.LENGTH_SHORT).show()
        val a:Int =100
        val boxA:Int?=a
        val anotherboxA:Int?=a

        Toast.makeText(applicationContext,"$a ,$boxA, $anotherboxA",Toast.LENGTH_SHORT).show()

        val i1:Int =10
        val s1:String=i1.toString()
        if(s1.equals("10"))
        {
            Toast.makeText(applicationContext,"$s1+.......",Toast.LENGTH_SHORT).show()
        }
            val text = """
               for (c in "foo")
               print(c)
                """

        Toast.makeText(applicationContext,"$text",Toast.LENGTH_SHORT).show()

        val text1 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

        Toast.makeText(applicationContext,"$text1",Toast.LENGTH_SHORT).show()

        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
        Toast.makeText(applicationContext,x[0].toString(),Toast.LENGTH_LONG).show()

        val acs=Array(10){i ->(i*5).toString()   }
        acs.forEach { Toast.makeText(applicationContext,it,Toast.LENGTH_SHORT).show() }

        val str="Abc Def Ghi"
        for (c in str.uppercase())
        {
            Toast.makeText(applicationContext,"$c \n",Toast.LENGTH_SHORT).show()
        }
        val s = "Hello, world!\n"
        Toast.makeText(applicationContext,"$s \n",Toast.LENGTH_SHORT).show()*/

    }

    /*fun my():Unit{
        Toast.makeText(applicationContext,"MY Function call...",Toast.LENGTH_SHORT).show()
    }
    fun my1(i1:String){
        Toast.makeText(applicationContext,"$i1",Toast.LENGTH_SHORT).show()
    }
    fun my2(i1: String):Int{
        return i1.length
    }
    fun sum(first:Int,second:Int):Int{
        return first+second
    }
    fun multiply(i1:Int,i2:Int):Int{
        return i1*i2
    }
    open class A{
        open fun foo(i:Int=10)
        {}
    }
    class B:A(){
        override fun foo(i: Int) {
            super.foo(i)
        }
        fun foo(bar:Int=0,baz:Int){}


    }
 fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }
*/
/*class A private constructor(){

        var a2="10"
fun ab():String{return a2}
}
    class Person(val name: String) {
        val children: MutableList<Person> = mutableListOf()
        constructor(name: String, parent: Person) : this(name) {
            parent.children.add(this)
        }
    }*/

}