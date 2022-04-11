package com.meliskara.assignment_6

import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (SharedPrefManager.getInstance(this).isLoggedIn) {
            val id = findViewById<TextView>(R.id.textViewId)
            val userName = findViewById<TextView>(R.id.textViewUsername)
            val userEmail = findViewById<TextView>(R.id.textViewEmail)
            val gender = findViewById<TextView>(R.id.textViewGender)
            val btnLogout = findViewById<Button>(R.id.buttonLogout)

            val user = SharedPrefManager.getInstance(this).user

            id.text = user.id.toString()
            userEmail.text = user.email
            gender.text = user.gender
            userName.text = user.name

            btnLogout.setOnClickListener(this)

        } else {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(view: View) {
        val btnLogout = findViewById<Button>(R.id.buttonLogout)
        if (view == btnLogout) {
            SharedPrefManager.getInstance(applicationContext).logout()
        }
    }
}