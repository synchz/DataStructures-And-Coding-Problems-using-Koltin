/**
* @author Prikshit
 *
 * Reverse given string
 *
* */
fun main(){
    println("Reversing string --> Hello World")
    println(reverseString("Hello World"))
}

fun reverseString(string: String): String {
    var reversedString = ""
    for(i in string.length-1 downTo 0)
        reversedString += string[i]
    return reversedString
}