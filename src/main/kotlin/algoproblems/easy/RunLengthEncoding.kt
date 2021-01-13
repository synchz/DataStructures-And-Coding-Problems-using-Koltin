package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Run-Length Encoding
 *
 * */

//Time Complexity O(n)
//Space Complexity O(n)
fun runLengthEncoding(string: String): String {
    var outStr = ArrayList<String>()
    var prev = ' '
    var count = 0
    for (s in string) {
        if ((s != prev && count > 0) || count == 9) {
            outStr.add("$count$prev")
            count = 0
        }
        prev = s
        count++
    }
    outStr.add("$count$prev")
    return outStr.joinToString("")
}
