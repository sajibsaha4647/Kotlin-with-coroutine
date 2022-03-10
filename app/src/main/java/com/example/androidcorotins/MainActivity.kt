package com.example.androidcorotins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {


    private  lateinit var zeroTv:TextView
    private lateinit var buttonOne:Button
    private lateinit var buttonTwo:Button
    private  var zero = 0
//    private lateinit var thread :Thread ;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zeroTv = findViewById(R.id.zeroid)
        buttonOne = findViewById(R.id.increment)
        buttonTwo = findViewById(R.id.decrement)

        zeroTv.setText(""+zero);

        //increment
        buttonOne.setOnClickListener{
            zero++
            zeroTv.setText(""+zero);
            Log.d("thread", "${Thread.currentThread().name}");
        }

        //decrement and useing coroutine all scope
        buttonTwo.setOnClickListener{
            if(zero == 0){}else{
                zero--
                zeroTv.setText(""+zero);
            }
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("thread", "1-${Thread.currentThread().name}");
            }

            GlobalScope.launch(Dispatchers.Main){
                Log.d("thread", "2-${Thread.currentThread().name}");
            }

            MainScope().launch(Dispatchers.Default){
                Log.d("thread", "3-${Thread.currentThread().name}");
            }

        }

//        forloop(10);

        CoroutineScope(Dispatchers.Main).launch {
//            Task1();
        }

        CoroutineScope(Dispatchers.Main).launch {
//            Task2()
        }

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    suspend fun printFollowers(){
        var follower = 0
      var job =  CoroutineScope(Dispatchers.IO).launch {
           follower = getFollowers()
       }
        job.join()
        println(follower)
    }

    suspend fun getFollowers():Int{
        delay(1000)
        return 54;

    }

    suspend fun Task1(){
        println("start task 1")
        yield()
        println("end task 1")
    }

    suspend fun Task2(){
        println("start task 2")
        yield()
        println("end task 2")
    }


    fun forloop(n:Int){ //here i using java thread function

        thread(start= true){
            for(i in 1..n){
                println("printing")
            }
        }

    }


}