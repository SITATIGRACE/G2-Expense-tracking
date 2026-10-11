package com.example.tenantmanagementsytem

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) {
    fun summary(): String {
        return "Tenant Name: $name, Phone: $phone, Rent Paid: Sh. $rent"
    }
}
