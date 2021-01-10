package leetcode

fun main(){
    println(longestPalindrome("ccc"))
    println(longestPalindrome("bb"))
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("abba"))
    println(longestPalindrome("ac"))
    println(longestPalindrome("gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv"))
}

fun longestPalindrome(s: String): String {
    var maxString = ""
    fun lengthOfPalindrome(l:Int, r:Int):Int{
        var ll = l
        var rr = r
        while(ll>=0 && rr<s.length && s[ll] == s[rr]){
            ll--
            rr++
        }
        return rr - ll - 1
    }
    for(i in s.indices){
        var l1 = lengthOfPalindrome(i,i)
        var l2 = lengthOfPalindrome(i,i+1)
        if(l1>l2 && l1>maxString.length) maxString = s.substring(i-(l1-1)/2, i+(l1/2)+1)
        else if(l2>l1 && l2>maxString.length) maxString = s.substring(i-(l2-1)/2, i+(l2/2)+1)
    }
    return maxString
}
// O n^2
fun `longestPalindromeon^2`(s: String): String {
    if(s.length < 2) return s
    var maxSize = 1
    var maxString = s[0].toString()
    for(i in 0 until s.length-1){
        var subStr:String = ""
        for(j in i+1 until s.length){
            subStr = s.substring(i, j+1)
            if(checkPalindrome(subStr)) {
                if(maxSize< subStr.length) {
                    maxSize = subStr.length
                    maxString = subStr
                }
            }
        }
    }
    return maxString
}

fun checkPalindrome(s: String):Boolean {
    var l = s.length-1
    var i = 0

    while (i<=l){
        if(s[i]==s[l]){
            i++
            l--
        }
        else return false
    }
    return true
}