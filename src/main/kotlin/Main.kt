import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    println(getDuplicatesCount("aabbcde"))
}

// 1
fun maskify(text: String): String {
    return if (text.length <= 4) {
        text
    } else {
        var replacement = ""
        for (i in 0..text.length - 4) {
            replacement += "#"
        }
        text.replaceRange(0, text.length - 4, replacement)
    }
}

// 2
fun findEvenIndex(array: List<Int>): Int {
    for (i in array.indices) {
        var rightSum = 0
        var leftSum = 0
        for (j in i downTo 0) {
            leftSum += array[j]
        }
        for (j in i until array.size) {
            rightSum += array[j]
        }
        if (leftSum == rightSum) {
            return i
        }
    }
    return -1
}

//3
fun cleanString(str: String): String {
    var result = StringBuilder()
    for (i in str.indices) {
        if (str[i] != '#') {
            result.append(str[i])
        } else {
            result.deleteCharAt(result.lastIndex)
        }
    }
    return result.toString()
}

// 4
fun phoneNumber(numbers: List<Byte>): String {
    if (numbers.size < 10) {
        throw IllegalArgumentException("Not phone number")
    }
    var phoneNumberString = StringBuilder()
    phoneNumberString.append("(${numbers[0]}${numbers[1]}${numbers[2]}) ")
    phoneNumberString.append("${numbers[3]}${numbers[4]}${numbers[5]}-${numbers[6]}${numbers[7]}${numbers[8]}${numbers[9]}")
    return phoneNumberString.toString()
}

// 5
fun usernameIsCorrect(username: String): Boolean {
    return Regex("^[a-z0-9._-]{4,16}\$").matches(username)
}

// region 8 kyu

// https://www.codewars.com/kata/53da3dbb4a5168369a0000fe
fun evenOrOdd(number: Int): String {
    return if (number % 2 == 0) "Even" else "Odd"
}

// https://www.codewars.com/kata/5715eaedb436cf5606000381
fun sumOfPositiveNumbers(numbers: List<Int>): Int {
    var sum = 0
    numbers.forEach { num ->
        if (num > 0) {
            sum += num
        }
    }
    return sum
}

// endregion

// region 7 kyo

// https://www.codewars.com/kata/554b4ac871d6813a03000035
fun lowesAndHighestNumbers(str: String): String {
    val numbers = str.split(' ').map { strNum -> strNum.toInt() }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    numbers.forEach { num ->
        if (num > max) {
            max = num
        }
        if (num < min) {
            min = num
        }
    }
    return "$max $min"
}

// https://www.codewars.com/kata/56747fd5cb988479af000028
fun getMiddleChar(str: String): String {
    return if (str.length % 2 == 0) {
        str[str.length / 2 - 1].toString() + str[str.length / 2].toString()
    } else {
        str[str.length / 2].toString()
    }
}

// endregion

// region 6 kyo
fun getDuplicatesCount(str: String): Int {
    var duplicatesCount = 0
    for (i in 1 until str.length) {
        for (j in i - 1..0) {
            if (str[i].lowercase() == str[j].lowercase()) {
                duplicatesCount++
            }
        }
    }
    return duplicatesCount
}
// endregion