package com.sprint.gina.kotlinfuns2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        // declare static properties and functions here
        val TAG = "MainActivityTag"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.textView)
        textView.setText("Let's learn Kotlin in 20 mins!!")

        // kotlin is an open-source, statically typed language
        // designed to be fully operable with Java
        // can mix .java and .kt files in the same project

        // variables
        // use var for a variable and val for a constant
        var x: Int = 5
        var y = 10
        val z: Int
        z = 7
        // string templates
        Log.d(TAG, "onCreate: x=$x y=$y y * 2=${y * 2}")

        // nullable: is a variable that is either a value or null
        var n: Int? = 5
        n = null
        n = 5
        // !! (non-null assertion operator)
        // ?. (null safety operator)
        // ?: (elvis operator)
        var myStr: String? = "hello"
        Log.d(TAG, "onCreate: " + myStr!!.length) // crash our code if myStr is null
        // best to have if (myStr != null)
        Log.d(TAG, "onCreate: " + myStr?.length) // .length will not be called if myStr is null
        val temp: String = myStr ?: "" // "" if myStr is null

        // if, when, for, and while statements are expressions that return a value
        val month = "December"
        val officeBuilding = if (month == "December") {
            "Bollier"
        }
        else {
            "Herak"
        }

        // many for loop styles
        for (i in 0..3) { // 0 to 3 inclusive
            Log.d(TAG, "onCreate: i=$i")
        }
        for (j in 5 downTo 0 step 1) {
            Log.d(TAG, "onCreate: j=$j")
        }
        
        // functions
        val nums = listOf(1, 2, 3, 4, 5)
        val sum = sumList(nums)
        Log.d(TAG, "onCreate: sum=$sum")
        
        // OOP
        // the default primary constructor is immediately available
        var dog = Dog("Odin", 9)
        Log.d(TAG, "onCreate: $dog")
    }
    
    open class Dog(var name: String = "DOG", var age: Int = 0) { // declare properties... this is called the primary constructor
        init {
            Log.d(TAG, "in init: ")
        }
        
        override fun toString(): String {
            return name + " is a " + age + " year old dog"
        }
    }

    class ShowDog(name: String, age: Int, var numAwards: Int) : Dog(name, age) {

    }
    
    fun sumList(nums: List<Int>): Int { // Unit like void
        var sum = 0
        for (num in nums) {
            sum += num
        }
        return sum 
    }
}