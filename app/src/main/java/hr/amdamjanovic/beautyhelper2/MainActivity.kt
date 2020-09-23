package hr.amdamjanovic.beautyhelper2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    register_button_register.setOnClickListener {
       performRegister()
    }
        already_have_an_account_textview.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            //ulazak u login_activity
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister(){
        val email=email_editText_register.text.toString()
        val password= password_editText_register.text.toString()

        if(email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Please enter text in email/password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "Email is: " + email)
        Log.d("MainActivity", "Password: $password")
        //Firebase authentication to create a user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!it.isSuccessful) return@addOnCompleteListener
            // else if successful
            Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
            val intent= Intent(this, ListActivity::class.java)
            startActivity(intent)


        }
            .addOnFailureListener {
                Log.d("Main", "Failed to create user: ${it.message}")
                Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

}




