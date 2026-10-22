
package com.example.tenantmanagementsytem

import java.io.Serializable

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {

    fun summary(): String {
        return "Tenant Name: $name, Phone: $phone, Rent Paid: Sh. $rent"
    }
}
