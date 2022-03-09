package com.example.androidcorotins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {


    private  lateinit var zeroTv:TextView
    private lateinit var buttonOne:Button
    private lateinit var buttonTwo:Button
    private  var zero = 0


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

        //decrement
        buttonTwo.setOnClickListener{
            if(zero == 0){}else{
                zero--
                zeroTv.setText(""+zero);
            }
            Log.d("thread", "${Thread.currentThread().name}");
        }

    }


}