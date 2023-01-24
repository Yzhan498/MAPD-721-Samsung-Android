package com.example.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<View>(R.id.btnLogin) as FloatingActionButton
        btnLogin.setOnClickListener {
            val edtUserName = findViewById<View>(R.id.edtUserName) as EditText
            val userName = edtUserName.text.toString()
            saveToPreferences(userName)
            val intent = Intent(applicationContext, ChatActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveToPreferences(userName: String) {
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("PREF_KEY_USER_NAME", userName)
        editor.apply()
    }
}