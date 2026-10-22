
package com.example.tenantmanagementsytem

object TenantRepository {

    private val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    fun getTenants(): List<Tenant> {
        return tenants.toList()
    }

    fun totalRent(): Double {
        return tenants.sumOf {
            it.rent.toDoubleOrNull() ?: 0.0
        }
    }
}
