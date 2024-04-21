package com.example.mobiledevproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val buttonAuth: Button = findViewById(R.id.button_auth)

        val RegLink: TextView = findViewById(R.id.reg_link)
        RegLink.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        buttonAuth.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth)
                {
                    Toast.makeText(this, "User $login has logged", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, ProductsActivity::class.java)
                    setContentView(R.layout.activity_products)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "User $login has NOT logged. Check your login and password", Toast.LENGTH_LONG).show()
                }

            }
        }

    }
}
