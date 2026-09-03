




     // Task 3.1: String Concatenation
    println(tenantName + " lives in house " + houseNumber)

    // Task 3.2: String Template
    println("$tenantName lives in house $houseNumber")

    //string template is easier to read

    // Task 3.3: Inline Math Expression
    println("Total rent for 6 months: KES ${monthlyRent * 6}")

    // Task 3.4: Triple-quoted string receipt
    //it removes the common indentation from the beginning of each line of a multiline string.
    val receipt = """
    ===== RENT RECEIPT =====
    Tenant: $tenantName
    House: $houseNumber
    Paid: KES $amountPaid
""".trimIndent() // removes the common indentation from the beginning of each line of a multiline string.

     //3.5 predicted one
     //val greeting = "Dear Tenant"
     //greeting.uppercase()
     //println(greeting)
     //greeting is unchanged because uppercase() returns a new String. It does not modify the original greeting



     //Change to uppercase
     val greeting = "Dear Tenant"
     println(greeting.uppercase())
     //4.1operators
     //outstanding balance
     val balance = monthlyRent - amountPaid
     println("Balance: KES $balance")
     //4.2percentage paid
     //predicted version
     //you will get a 0%
     //val percentPaid = (amountPaid / monthlyRent) * 100

     //println("Paid: $percentPaid%")

     //correct method
     //gives you 80%
     val percentPaid = (amountPaid * 100) / monthlyRent

     println("Paid: $percentPaid%")



     //4.3 Division and remainder
     val instalmentAmount = 6000
     val fullInstalments = monthlyRent / instalmentAmount
     val remainingAmount = monthlyRent % instalmentAmount

     println("Full instalments: $fullInstalments")
     println("Remaining amount: KES $remainingAmount")

     //4.4 Numeric operator
     val totalRent = monthlyRent.times(6)

     println("Total rent for 6 months: KES $totalRent")

     //4.5 is rent paid boolean
     val isRentPaid: Boolean = amountPaid >= monthlyRent
     println("Is rent fully paid? $isRentPaid")

     //4.6 need reminder
     var monthsInArrears = 2
     val rentIsOutstanding = amountPaid < monthlyRent

     // True only if rent is outstanding AND months in arrears is strictly greater than 1
     var needsReminder = rentIsOutstanding && (monthsInArrears > 1)
     println("Needs reminder (2 months): $needsReminder")


     //5.1Making Decisions
     if (amountPaid >= monthlyRent) {
         println("Rent is fully paid")
     } else {
         println("Rent is outstanding")
     }
     //5.2
     val currentBalance = monthlyRent - amountPaid

     if (currentBalance <= 0) {
         println("Rent is fully paid")
     } else if (currentBalance < 10000) {
         println("Small outstanding balance")
     } else {
         println("Large outstanding balance")
     }
//5.3 using when statement
     when {
         currentBalance <= 0 -> println("Rent is fully paid")
         currentBalance < 10000 -> println("Small outstanding balance")
         else -> println("Large outstanding balance")
     }
     //5.4 Months in arrears
     val testArrears = 2 // Change this to 0, 4, 8, or 15 to test different branches

     when (testArrears) {
         0 -> println("Rent is up to date")
         in 1..2 -> println("Early arrears")
         in 3..5 -> println("Serious arrears")
         in 6..12 -> println("Critical arrears")
         else -> println("Review tenant account")
     }
     //5.5tenant status
     val tenantStatus = "ACTIVE"

     when (tenantStatus) {
         "ACTIVE" -> println("Tenant currently occupies the unit.")
         "VACATED" -> println("Tenant has moved out of the property.")
         "PENDING" -> println("Application is awaiting approval.")
         else -> println("Unknown status configuration.")
     }
//6.1months 1-12
     for (month in 1..12) {
         println(month)
     }
//6.2 every second month
     for (month in 1..12 step 2) {
         println("Checking payment history for month $month")
     }
//6.3countdown
     for (month in 5 downTo 1) {
         println(month)
     }
     //6.4 with index ()
     val tenantNames= listOf("Jane", "Brian", "Mary", "David")
     for ((index, tenant) in tenantNames.withIndex()) {
         println("${index + 1}. $tenant")
     }
     //6.5 while loop
     var vacantHouses = 0

     while (vacantHouses > 0) {
         println("Checking vacant houses...")
     }
//6.6 do while loop
     repeat(3) {
         println("Please pay your rent.")

     }
     //6.7 repeat()
     repeat(3) {
         println("Please pay your rent.")
     //Part 7 — Lists and Arrays
    val tenantList = listOf("Jane Wanjiku", "Brian Otieno", "Mary Achieng", "John Kamau")
    println("First: ${tenantList.first()}, Last: ${tenantList[tenantList.size - 1]}")
    val houses = arrayOf("A-101", "A-102", "A-103", "A-104")
    println("Second house: ${houses[1]}")
    houses[0] = "A-201"
    println(houses.joinToString(", "))
    //Part 8 - Null Safety
    val tenantEmail: String? = null
    println(tenantEmail)
    println("Email: ${tenantEmail ?: "Not provided"}")
    val nextOfKin: String? = "John Doe"
    println(nextOfKin?.uppercase() ?: "No next of kin on record")






