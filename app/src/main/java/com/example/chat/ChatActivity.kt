package com.example.chat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

open class ChatActivity : AppCompatActivity() {
    // See: https://developer.android.com/training/basics/intents/result
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        Firebase.auth.signOut()
    }
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val user = FirebaseAuth.getInstance().currentUser
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }
//    private fun joinChat() {
//        val data = Bundle()
//        data.putInt(ChatService.CMD, ChatService.CMD_JOIN_CHAT)
//        val intent = Intent(this, ChatService::class.java)
//        intent.putExtras(data)
//        startService(intent)
//    }
//
//    private fun leaveChat() {
//        val data = Bundle()
//        data.putInt(ChatService.CMD, ChatService.CMD_LEAVE_CHAT)
//        val intent = Intent(this, ChatService::class.java)
//        intent.putExtras(data)
//        startService(intent)
//    }

//    companion object {
//        private const val TAG = "ChatActivity"
//    }

}