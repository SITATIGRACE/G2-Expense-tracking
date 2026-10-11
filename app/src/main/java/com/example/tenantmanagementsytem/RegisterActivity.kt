package com.example.tenantmanagementsytem

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsytem.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // All registration logic is safely contained inside this click listener
        binding.registerButton.setOnClickListener {
            val fullName = binding.fullNameEditText.text.toString().trim()
            val email = binding.registerEmailEditText.text.toString().trim()
            val password = binding.registerPasswordEditText.text.toString()

            // 1. Validation Check
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. Success Feedback
            Toast.makeText(
                this,
                "Account created. Please log in.",
                Toast.LENGTH_SHORT
            ).show()

            // 3. Navigation to Login Activity with the registered email
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("EMAIL", email)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        // Quick link to close registration and return to the underlying Login screen
        binding.loginLinkTextView.setOnClickListener {
            finish()
        }
    }
}