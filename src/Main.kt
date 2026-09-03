fun main() {

    println("-------------------------------------------------------------------")
    println("--------------Welcome to the Tenant Management System--------------")
    println("-------------------------------------------------------------------")
    println()

    println("---------Tenant One--------")

    // ============================================================
    // PART 1: VARIABLES
    // ============================================================

    // Task 1.1 – Declare Tenant Variables

    val tenantId: Int = 1001
    val tenantName: String = "Jane Wanjiku"
    val phoneNumber: String = "0712345678"
    val houseNumber: String = "A-204"
    val monthlyRent: Int = 25000
    var amountPaid: Int = 15000

    // Task 1.1 Answers:
    //
    // Tenant ID should be val because the tenant ID does not change.
    //
    // Tenant Name should be val because the tenant name does not
    // change in this exercise.
    //
    // Phone Number should be val because the phone number does not
    // change in this exercise.
    //
    // House Number should be val because the house number does not
    // change in this exercise.
    //
    // Monthly Rent should be val because the monthly rent is fixed
    // in this exercise.
    //
    // Amount Paid should be var because the tenant can make additional
    // payments, so the amount paid can change.


    // ============================================================
    // Task 1.2 – Update amountPaid
    // ============================================================

    println("Amount paid before: $amountPaid")

    amountPaid = amountPaid + 5000

    println("Amount paid after: $amountPaid")

    // Expected output:
    // Amount paid before: 15000
    // Amount paid after: 20000


    // ============================================================
    // Task 1.3 – Deliberately Try to Change tenantId
    // ============================================================

    // Deliberate error:
    // tenantId = 1002

    // Answer:
    // Exact error message: Val cannot be reassigned
    //
    // The compiler refuses because tenantId was declared using val.
    // A val variable cannot be reassigned.
    //
    // The single-word change that would make it compile is:
    // var
    //
    // Example:
    // var tenantId: Int = 1001
    // tenantId = 1002
    //
    // The change should then be undone.


    // ============================================================
    // PART 2: DATA TYPES AND CASTING
    // ============================================================

    // ============================================================
    // Task 2.1 – Explicit Type Annotations
    // ============================================================

    // The six variables above have explicit type annotations:
    //
    // tenantId -> Int
    // tenantName -> String
    // phoneNumber -> String
    // houseNumber -> String
    // monthlyRent -> Int
    // amountPaid -> Int
    //
    // Why is phoneNumber a String and not an Int?
    //
    // 1. A phone number may contain special characters such as
    //    + or -.
    //
    // 2. A phone number is identification/contact data and is not
    //    used for mathematical calculations.
    //
    // It can also begin with zero, such as 0712345678.


    // ============================================================
    // Task 2.2 – Char and Boolean
    // ============================================================

    val block: Char = 'A'
    val isActive: Boolean = true

    println("Block: $block")
    println("Is Active: $isActive")


    // ============================================================
    // Task 2.3 – Int to Double Conversion
    // ============================================================

    // Deliberate error:
    // val rentAsDouble: Double = monthlyRent

    // Answer:
    // It will NOT compile because monthlyRent is an Int,
    // while rentAsDouble requires a Double.
    //
    // Error message:
    // Type mismatch: inferred type is Int but Double was expected.
    //
    // Kotlin requires explicit conversion to maintain strict type
    // safety and prevent unexpected numeric conversions.


    // Correct version:
    val rentAsDouble: Double = monthlyRent.toDouble()

    println("Rent as Double: $rentAsDouble")


    // ============================================================
    // Task 2.4 – Long Declaration with Underscores
    // ============================================================

    val companyRegNo: Long = 999_999_999L

    println("Company Registration Number: $companyRegNo")

    // The underscores make the number easier to read in the code.
    // They do not appear in the output.
    //
    // Output:
    // Company Registration Number: 999999999


    // ============================================================
    // TENANT INFORMATION
    // ============================================================

    println()
    println("---------Tenant Information---------")
    println("Tenant ID: $tenantId")
    println("Tenant Name: $tenantName")
    println("Tenant Phone Number: $phoneNumber")
    println("House Number: $houseNumber")
    println("Monthly Rent: KES $monthlyRent")
    println("Amount Paid: KES $amountPaid")
}