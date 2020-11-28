package codewars.spinwords

/**
 * Reverse every word in a sentence with a length bigger than 4
 */
fun spinWords(sentence: String) = sentence.split(" ")
        .joinToString(" ") { if (it.length > 4) it.reversed() else it }


fun main(array: Array<String>) {
    println("Result: " + spinWords("Welcome"))
}
