fun validatePassword(password: String): Boolean {
    if (password.length < 8) return false

    var hasDigit = false
    var hasUpper = false
    var hasSpecial = false

    for (char in password) {
        if (char in '0'..'9') hasDigit = true
        if (char in 'A'..'Z' || char in 'А'..'Я') hasUpper = true
        if (!char.isLetterOrDigit()) hasSpecial = true
    }

    return hasDigit && hasUpper && hasSpecial
}

fun formatPhoneNumber(phone: String): String {
    var digits = ""
    for (char in phone) {
        if (char in '0'..'9') digits += char
    }

    if (digits.length == 11) {
        val code = digits.substring(1, 4)
        val p1 = digits.substring(4, 7)
        val p2 = digits.substring(7, 9)
        val p3 = digits.substring(9, 11)
        return "+7 ($code) $p1-$p2-$p3"
    }
    return phone
}

fun filterEvenNumbers(numbers: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (n in numbers) {
        if (n % 2 == 0) {
            result.add(n)
        }
    }
    return result
}

fun sumOfDigits(number: Int): Int {
    var n = number
    if (n < 0) n = -n
    var sum = 0
    while (n > 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}

fun generatePassword(length: Int): String {
    val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*"
    var password = ""
    for (i in 1..length) {
        val randomIndex = (0 until chars.length).random()
        password += chars[randomIndex]
    }
    return password
}

fun findDuplicates(list: List<Int>): List<Int> {
    val duplicates = mutableListOf<Int>()
    val seen = mutableListOf<Int>()

    for (item in list) {
        if (item in seen) {
            if (item !in duplicates) {
                duplicates.add(item)
            }
        } else {
            seen.add(item)
        }
    }
    return duplicates
}

fun reverseString(str: String): String {
    var result = ""
    for (i in str.length - 1 downTo 0) {
        result += str[i]
    }
    return result
}

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}

fun convertTemperature(temp: Double, toFahrenheit: Boolean): Double {
    if (toFahrenheit) {
        return (temp * 9 / 5) + 32
    } else {
        return (temp - 32) * 5 / 9
    }
}

fun main() {
    println("Task 1:")
    println(validatePassword("Pass123!"))
    println(validatePassword("weak"))

    println("\nTask 2:")
    println(formatPhoneNumber("89123456789"))

    println("\nTask 3:")
    println(filterEvenNumbers(listOf(1, 2, 3, 4, 5, 6)))

    println("\nTask 4:")
    println(sumOfDigits(12345))

    println("\nTask 5:")
    println(generatePassword(10))

    println("\nTask 6:")
    println(findDuplicates(listOf(1, 2, 3, 2, 4, 5, 1, 1)))

    println("\nTask 7:")
    println(reverseString("Android"))

    println("\nTask 8:")
    println(isPrime(7))
    println(isPrime(10))

    println("\nTask 9:")
    println(convertTemperature(25.0, true))
    println(convertTemperature(77.0, false))
}