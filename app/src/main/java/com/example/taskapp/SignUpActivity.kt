package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {

    lateinit var etsignemail: EditText
    lateinit var etsignPassword: EditText
    lateinit var etConformPassword: EditText
    lateinit var btnsignup: Button
    lateinit var btn_Login: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnsignup = findViewById(R.id.btnsignup)
        etsignemail = findViewById(R.id.etsignemail)
        etsignPassword = findViewById(R.id.etsignPassword)
        etConformPassword = findViewById(R.id.etConformPassword)
        btn_Login = findViewById(R.id.btn_Login)

        btnsignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_Login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}