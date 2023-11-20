fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Please provide a single integer argument.")
        return
    }

    val inputNumber: Int
    try {
        inputNumber = args[0].toInt()
    } catch (e: NumberFormatException) {
        println("Invalid input. Please provide a valid integer.")
        return
    }

    if (inputNumber < 0 || inputNumber > 999999) {
        println("Please provide an integer between 0 and 999999.")
        return
    }

    val result = numberToWords(inputNumber)
    println("Number in words: $result")
}

fun numberToWords(number: Int): String {
    val units = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val teens = arrayOf("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    if (number == 0) {
        return "Zero"
    }

    val sb = StringBuilder()

    if (number / 100000 > 0) {
        sb.append(units[number / 100000]).append(" Hundred ")
        number %= 100000
    }

    if (number / 10000 > 0) {
        if (number / 10000 == 1) {
            sb.append(teens[number % 10]).append(" Thousand ")
            number /= 10
        } else {
            sb.append(tens[number / 10000]).append(" ")
            number %= 10000
        }
    }

    if (number / 1000 > 0) {
        sb.append(units[number / 1000]).append(" Thousand ")
        number %= 1000
    }

    if (number / 100 > 0) {
        sb.append(units[number / 100]).append(" Hundred ")
        number %= 100
    }

    if (number > 0) {
        if (sb.isNotEmpty()) {
            sb.append("and ")
        }

        if (number < 10) {
            sb.append(units[number])
        } else if (number < 20) {
            sb.append(teens[number - 10])
        } else {
            sb.append(tens[number / 10]).append(" ")
            if (number % 10 > 0) {
                sb.append(units[number % 10])
            }
        }
    }

    return sb.toString()
}
