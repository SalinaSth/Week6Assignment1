package com.salina.softuser_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var text_input_usName: TextInputLayout
    private lateinit var text_input_pwd: TextInputLayout
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_input_usName = findViewById(R.id.text_input_usName)
        text_input_pwd = findViewById(R.id.text_input_pwd)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if (TextUtils.isEmpty(text_input_usName.editText?.text)){
                text_input_usName.editText?.error = "Username is empty"
                text_input_usName.editText?.requestFocus()
                return@setOnClickListener
            }else if(TextUtils.isEmpty(text_input_pwd.editText?.text)){
                text_input_pwd.editText?.error = "Password is empty"
                text_input_pwd.editText?.requestFocus()
                return@setOnClickListener
            }
            login()
        }
    }

    private fun login(){
        val usName = text_input_usName.editText?.text.toString()
        val pwd = text_input_pwd.editText?.text.toString()
        if (usName == "softwarica" && pwd == "coventry"){
            val intent = Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
        }

    }
}