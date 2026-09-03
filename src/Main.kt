




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






