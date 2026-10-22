package com.example.tenantmanagementsytem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsytem.databinding.FragmentAddTenantBinding

class AddTenantFragment : Fragment() {

    private var _binding: FragmentAddTenantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTenantBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveTenantButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.tenantPhoneEditText.text.toString().trim()
            val rent = binding.tenantRentEditText.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || rent.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val rentAmount = rent.toDoubleOrNull()

            if (rentAmount == null || rentAmount < 0) {
                Toast.makeText(
                    requireContext(),
                    "Please enter a valid rent amount",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val tenant = Tenant(
                name = name,
                phone = phone,
                rent = rent
            )

            TenantRepository.addTenant(tenant)

            Toast.makeText(
                requireContext(),
                "Tenant saved successfully",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
