package hr.amdamjanovic.beautyhelper2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_button_login.setOnClickListener addOnCompleteListener@{
            val email= login_edittext_email.text.toString()
            val password = login_edittext_password.text.toString()

            Log.d("Login", "Attempt login with email/pw: $email/***")
            val intent= Intent(this, ListActivity::class.java)
            startActivity(intent)


            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)


        }


        back_to_register_textView.setOnClickListener {
            finish()
        }
    }
}
