

fun main() {
    println("========================================")
    println("     ENVELOPE EXPENSE TRACKER")
    println("========================================")
    println("\nWelcome to the Hela Expense Tracker!")
    println("Track your spending with ease.")
    println("Set budgets, log expenses, and view your spending summary.")
    println("\nLet's get started!")




    val currency = "Sh."

    // Mutable variables for the program
    var running = true
    var categoryInput: String
    var amountInput: Double
    var descriptionInput: String
    var choice: String



    // Collections using MutableList to store data
    val categories = mutableListOf("Food", "Transport", "Entertainment")
    val budgets = mutableListOf(2000.00, 1000.00, 5000.00)

    // Separate expense lists for each category
    val foodExpenses = mutableListOf<Pair<String, Double>>()
    val transportExpenses = mutableListOf<Pair<String, Double>>()
    val entertainmentExpenses = mutableListOf<Pair<String, Double>>()


    while (running) {

        println("\n--------------------------------------")
        println("MAIN MENU")
        println("--------------------------------------")
        println("1. Set Category Budget")
        println("2. Log an Expense")
        println("3. View Balances")
        println("4. Exit")
        println("========================================")
        print("Select an option (1-4): ")

        choice = readlnOrNull()?.trim() ?: ""


        if (choice == "1") {
            println("\n--------------------------------------")
            println("SET CATEGORY BUDGET")
            println("--------------------------------------")
            println("Available categories:")
            println("  1. ${categories[0]}")
            println("  2. ${categories[1]}")
            println("  3. ${categories[2]}")
            print("Enter category name: ")
            categoryInput = readlnOrNull()?.trim() ?: ""

            if (categoryInput == categories[0] || categoryInput == categories[1] || categoryInput == categories[2]) {
                print("Enter budget amount ($currency): ")
                amountInput = readlnOrNull()?.toDoubleOrNull() ?: 0.00

                if (amountInput > 0) {
                    // Update the budget
                    if (categoryInput == categories[0]) {
                        budgets[0] = amountInput
                    } else if (categoryInput == categories[1]) {
                        budgets[1] = amountInput
                    } else if (categoryInput == categories[2]) {
                        budgets[2] = amountInput
                    }

                    println("\n----------------------------------------")
                    println("BUDGET SET SUCCESSFULLY")
                    println("----------------------------------------")
                    println("Category: $categoryInput")
                    println("Budget: $currency ${String.format("%.2f", amountInput)}")
                    println("----------------------------------------")
                } else {
                    println("\n[ERROR] Invalid amount. Please enter a positive number.")
                }
            } else {
                println("\n[ERROR] Category '$categoryInput' not found. Please choose from the available categories.")
            }

        } else if (choice == "2") {
            // LOG EXPENSE
            println("\n--------------------------------------")
            println("LOG AN EXPENSE")
            println("--------------------------------------")
            println("Available categories:")
            println("  1. ${categories[0]}")
            println("  2. ${categories[1]}")
            println("  3. ${categories[2]}")
            print("Enter category name: ")
            categoryInput = readlnOrNull()?.trim() ?: ""

            if (categoryInput == categories[0] || categoryInput == categories[1] || categoryInput == categories[2]) {
                print("Enter expense description: ")
                descriptionInput = readlnOrNull()?.trim() ?: ""

                if (descriptionInput.isEmpty()) {
                    println("\n[ERROR] Description cannot be empty.")
                } else {
                    print("Enter amount ($currency): ")
                    amountInput = readlnOrNull()?.toDoubleOrNull() ?: 0.0

                    if (amountInput > 0) {
                        // Variables for budget checking
                        var budgetAmount = 0.00
                        var totalSpent = 0.00
                        var remainingBudget = 0.00

                        // Check which category and calculate spending
                        if (categoryInput == categories[0]) {
                            budgetAmount = budgets[0]
                            totalSpent = 0.00
                            var i = 0
                            while (i < foodExpenses.size) {
                                totalSpent = totalSpent + foodExpenses[i].second
                                i = i + 1
                            }
                            remainingBudget = budgetAmount - totalSpent
                        } else if (categoryInput == categories[1]) {
                            budgetAmount = budgets[1]
                            totalSpent = 0.00
                            var i = 0
                            while (i < transportExpenses.size) {
                                totalSpent = totalSpent + transportExpenses[i].second
                                i = i + 1
                            }
                            remainingBudget = budgetAmount - totalSpent
                        } else if (categoryInput == categories[2]) {
                            budgetAmount = budgets[2]
                            totalSpent = 0.00
                            var i = 0
                            while (i < entertainmentExpenses.size) {
                                totalSpent = totalSpent + entertainmentExpenses[i].second
                                i = i + 1
                            }
                            remainingBudget = budgetAmount - totalSpent
                        }


                        if (amountInput > remainingBudget && remainingBudget >= 0) {
                            println("\n[WARNING] This expense (${String.format("%.2f", amountInput)}) exceeds your remaining budget (${String.format("%.2f", remainingBudget)})!")
                            print("Do you still want to continue? (y/n): ")
                            val confirm = readlnOrNull()?.lowercase() ?: ""

                            if (confirm == "y") {
                                // Add the expense
                                if (categoryInput == categories[0]) {
                                    foodExpenses.add(Pair(descriptionInput, amountInput))
                                    totalSpent = totalSpent + amountInput
                                    remainingBudget = budgetAmount - totalSpent
                                } else if (categoryInput == categories[1]) {
                                    transportExpenses.add(Pair(descriptionInput, amountInput))
                                    totalSpent = totalSpent + amountInput
                                    remainingBudget = budgetAmount - totalSpent
                                } else if (categoryInput == categories[2]) {
                                    entertainmentExpenses.add(Pair(descriptionInput, amountInput))
                                    totalSpent = totalSpent + amountInput
                                    remainingBudget = budgetAmount - totalSpent
                                }

                                println("\n----------------------------------------")
                                println("EXPENSE LOGGED SUCCESSFULLY")
                                println("----------------------------------------")
                                println("Category: $categoryInput")
                                println("Description: $descriptionInput")
                                println("Amount: $currency ${String.format("%.2f", amountInput)}")
                                println("Remaining Budget: $currency ${String.format("%.2f", remainingBudget)}")
                                println("----------------------------------------")

                                if (remainingBudget < 0) {
                                    println("[WARNING] You have exceeded your budget by $currency ${String.format("%.2f", remainingBudget * -1)}")
                                }
                            } else {
                                println("\nTransaction cancelled.")
                            }
                        } else {
                            // Add the expense (within budget)
                            if (categoryInput == categories[0]) {
                                foodExpenses.add(Pair(descriptionInput, amountInput))
                                totalSpent = totalSpent + amountInput
                                remainingBudget = budgetAmount - totalSpent
                            } else if (categoryInput == categories[1]) {
                                transportExpenses.add(Pair(descriptionInput, amountInput))
                                totalSpent = totalSpent + amountInput
                                remainingBudget = budgetAmount - totalSpent
                            } else if (categoryInput == categories[2]) {
                                entertainmentExpenses.add(Pair(descriptionInput, amountInput))
                                totalSpent = totalSpent + amountInput
                                remainingBudget = budgetAmount - totalSpent
                            }

                            println("\n----------------------------------------")
                            println("EXPENSE LOGGED SUCCESSFULLY")
                            println("----------------------------------------")
                            println("Category: $categoryInput")
                            println("Description: $descriptionInput")
                            println("Amount: $currency ${String.format("%.2f", amountInput)}")
                            println("Remaining Budget: $currency ${String.format("%.2f", remainingBudget)}")
                            println("----------------------------------------")

                            if (remainingBudget < 0) {
                                println("[WARNING] You have exceeded your budget by $currency ${String.format("%.2f", remainingBudget * -1)}")
                            }
                        }
                    } else {
                        println("\n[ERROR] Invalid amount. Please enter a positive number.")
                    }
                }
            } else {
                println("\n[ERROR] Category '$categoryInput' not found. Please choose from the available categories.")
            }

        } else if (choice == "3") {
            // VIEW BALANCES
            println("\n========================================")
            println("BALANCE SUMMARY")
            println("========================================")

            // Variables for totals
            var totalBudget = 0.00
            var grandTotalSpent = 0.00
            var totalSpent: Double
            var i: Int

            println("\n----------------------------------------")
            println("CATEGORY BALANCES")
            println("----------------------------------------")

            // Food Category
            totalSpent = 0.00
            i = 0
            while (i < foodExpenses.size) {
                totalSpent = totalSpent + foodExpenses[i].second
                i = i + 1
            }
            totalBudget = totalBudget + budgets[0]
            grandTotalSpent = grandTotalSpent + totalSpent

            println("${categories[0]}:")
            println("  Budget: $currency ${String.format("%.2f", budgets[0])}")
            println("  Spent:  $currency ${String.format("%.2f", totalSpent)}")
            println("  Remaining: $currency ${String.format("%.2f", budgets[0] - totalSpent)}")

            if (foodExpenses.size > 0) {
                println("  Recent Expenses:")
                if (foodExpenses.size >= 2) {
                    println("    • ${foodExpenses[foodExpenses.size - 2].first}: $currency ${String.format("%.2f", foodExpenses[foodExpenses.size - 2].second)}")
                }
                println("    • ${foodExpenses[foodExpenses.size - 1].first}: $currency ${String.format("%.2f", foodExpenses[foodExpenses.size - 1].second)}")
            } else {
                println("  No expenses logged yet.")
            }
            println()

            // Transport Category
            totalSpent = 0.00
            i = 0
            while (i < transportExpenses.size) {
                totalSpent = totalSpent + transportExpenses[i].second
                i = i + 1
            }
            totalBudget = totalBudget + budgets[1]
            grandTotalSpent = grandTotalSpent + totalSpent

            println("${categories[1]}:")
            println("  Budget: $currency ${String.format("%.2f", budgets[1])}")
            println("  Spent:  $currency ${String.format("%.2f", totalSpent)}")
            println("  Remaining: $currency ${String.format("%.2f", budgets[1] - totalSpent)}")

            if (transportExpenses.size > 0) {
                println("  Recent Expenses:")
                if (transportExpenses.size >= 2) {
                    println("    • ${transportExpenses[transportExpenses.size - 2].first}: $currency ${String.format("%.2f", transportExpenses[transportExpenses.size - 2].second)}")
                }
                println("    • ${transportExpenses[transportExpenses.size - 1].first}: $currency ${String.format("%.2f", transportExpenses[transportExpenses.size - 1].second)}")
            } else {
                println("  No expenses logged yet.")
            }
            println()

            // Entertainment Category
            totalSpent = 0.00
            i = 0
            while (i < entertainmentExpenses.size) {
                totalSpent = totalSpent + entertainmentExpenses[i].second
                i = i + 1
            }
            totalBudget = totalBudget + budgets[2]
            grandTotalSpent = grandTotalSpent + totalSpent

            println("${categories[2]}:")
            println("  Budget: $currency ${String.format("%.2f", budgets[2])}")
            println("  Spent:  $currency ${String.format("%.2f", totalSpent)}")
            println("  Remaining: $currency ${String.format("%.2f", budgets[2] - totalSpent)}")

            if (entertainmentExpenses.size > 0) {
                println("  Recent Expenses:")
                if (entertainmentExpenses.size >= 2) {
                    println("    • ${entertainmentExpenses[entertainmentExpenses.size - 2].first}: $currency ${String.format("%.2f", entertainmentExpenses[entertainmentExpenses.size - 2].second)}")
                }
                println("    • ${entertainmentExpenses[entertainmentExpenses.size - 1].first}: $currency ${String.format("%.2f", entertainmentExpenses[entertainmentExpenses.size - 1].second)}")
            } else {
                println("  No expenses logged yet.")
            }
            println()

            println("--------------------------------------")
            println("GRAND TOTAL")
            println("--------------------------------------")
            println("Total Budget: $currency ${String.format("%.2f", totalBudget)}")
            println("Total Spent:  $currency ${String.format("%.2f", grandTotalSpent)}")
            println("Total Remaining: $currency ${String.format("%.2f", totalBudget - grandTotalSpent)}")
            println("--------------------------------------")

            // Spending percentage
            if (totalBudget > 0) {
                val percentUsed = (grandTotalSpent / totalBudget) * 100
                println("\nOverall Spending: ${String.format("%.1f", percentUsed)}% of total budget used.")

                if (percentUsed > 90) {
                    println("[WARNING] You have used over 90% of your total budget!")
                } else if (percentUsed > 70) {
                    println("[INFO] You have used over 70% of your total budget. Consider reducing spending.")
                } else {
                    println("[INFO] Your spending is on track.")
                }
            }

        } else if (choice == "4") {
            // EXIT
            println("\n==========================================================")
            println("THANK YOU FOR USING THE ENVELOPE EXPENSE TRACKER!")
            println("============================================================")
            running = false

        } else {
            println("\n[ERROR] Invalid option. Please select 1, 2, 3, or 4.")
        }
    }
}