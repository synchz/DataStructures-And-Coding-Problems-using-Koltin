/**
* @author Prikshit
 *
 * Reverse given string
 *
* */
fun main(){
    println("Reversing string --> Hello World")
    println(reverseString("Hello World"))
    println(reverseStringRecursive("Hello World"))
}

fun reverseString(string: String): String {
    var reversedString = ""
    for(i in string.length-1 downTo 0)
        reversedString += string[i]
    return reversedString
}

fun reverseStringRecursive(string: String): String{
    if(string.length<=1) return string
    return reverseStringRecursive(string.substring(1, string.length))+string[0]
}