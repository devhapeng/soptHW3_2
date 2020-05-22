package com.example.sopthw3_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.sign_activity.*

class RegisterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_activity)

        button.setOnClickListener {
            val email = editText1.text.toString()
            val password = editText2.text.toString()

            val nextIntent = Intent(this, LoginActivity::class.java)
            nextIntent.putExtra("email",email)
            nextIntent.putExtra("password",password)

            setResult(Activity.RESULT_OK, nextIntent)
            finish()
        }
    }

}