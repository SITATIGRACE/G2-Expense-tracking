
package com.example.tenantmanagementsytem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tenantmanagementsytem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTenantsBinding.inflate(
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

        displayTenants()
    }

    private fun displayTenants() {
        val tenants = TenantRepository.getTenants()

        binding.totalRentTextView.text =
            "Total Rent: KSh %.2f".format(TenantRepository.totalRent())

        binding.tenantsListTextView.text = if (tenants.isEmpty()) {
            "No tenants registered yet."
        } else {
            tenants.joinToString(separator = "\n\n") { tenant ->
                tenant.summary()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
