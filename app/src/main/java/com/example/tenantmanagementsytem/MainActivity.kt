package com.example.tenantmanagementsytem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsytem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. SAVE BUTTON LOGIC
        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            // Input Validation Check (Bonus Challenge #3 from Lab guide page 15)
            if (name.isEmpty() || phone.isEmpty() || rent.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields before saving", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tenant = Tenant(name, phone, rent)
            lastTenant = tenant

            // Updates the layout results TextView to visually display the structural info details
            binding.tenantResultTextView.text = tenant.summary()

            Toast.makeText(this, "Tenant details saved locally!", Toast.LENGTH_SHORT).show()
        }

        // 2. CALL TENANT BUTTON LOGIC (Step 12 Mandatory requirement)
        binding.callButton.setOnClickListener {
            val tenant = lastTenant

            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Launches system dialer interface
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            startActivity(intent)
        }

        // 3. SHARE TENANT BUTTON LOGIC (Bonus Challenge #1 from Lab guide page 15)
        binding.shareButton.setOnClickListener {
            val tenant = lastTenant

            if (tenant == null) {
                Toast.makeText(this, "Please input details and click SAVE first!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Builds the text payload package data tracking pipeline
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, tenant.summary())
                type = "text/plain"
            }

            try {
                // Creates a clean, safe system share manager pop-up menu wrapper intent
                val chooserIntent = Intent.createChooser(sendIntent, "Share tenant summary via:")
                startActivity(chooserIntent)
            } catch (e: Exception) {
                // Absolute structural hardware fallback security trigger
                startActivity(sendIntent)
            }
        }
    }
}
