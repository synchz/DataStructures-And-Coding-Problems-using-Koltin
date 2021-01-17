package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Caesar Cipher Encryptor
 *
 * */

//Time Complexity O(n)
//Space Complexity O(n)
fun caesarCipherEncryptor(string: String, key: Int): String {
    var outStr = Array(string.length){' '}
    var firstChar = 'a'.toInt()
    var i = 0
    for(s in string){
        outStr[i++] = (((s.toInt() - firstChar + key)%26)+firstChar).toChar()
    }
    return outStr.joinToString("")
}