package leetcode

fun main(){
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("   "))
    println(lengthOfLongestSubstring(""))
}

fun lengthOfLongestSubstring(s: String): Int {
    var maxCount = 0
    var map = HashMap<Char, Int>()
    var currentCount = 0
    var startIndex = 0
    for(i in s.indices){
        var c = s[i]
        if(map.contains(c)){
            if(map[c]!! >= startIndex) {
                if (currentCount > maxCount) maxCount = currentCount
                currentCount -=(map[c]!! - startIndex + 1)
                startIndex = map[c]!!+1
            }
        }
        currentCount++
        map[c] = i
    }
    if (currentCount > maxCount) maxCount = currentCount
    return maxCount
}