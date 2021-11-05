package com.example.kotlin_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText:EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)

        val resultButton: Button = findViewById(R.id.resultButton)

        resultButton.setOnClickListener{


            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값을 채워주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //return 문으로 실행을 종료. 이후의 연산이 실행되지 않음.
            //값을 넣지 않으면 실행이 되지 않음.

            val height:Int = heightEditText.text.toString().toInt()
            val weight:Int = weightEditText.text.toString().toInt()
            //height와 weight를 Int형으로 선언하기위해서 text를 문자열로, 문자열에서 Int로 변환해줌.

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
        }


    }
}