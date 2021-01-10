package leetcode

fun main() {
    var grp1 = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    printArrOfArr(grp1)
    var grp2 = groupAnagrams(arrayOf(""))
    printArrOfArr(grp2)
    var grp3 = groupAnagrams(arrayOf("s"))
    printArrOfArr(grp3)
    var grp4 = groupAnagrams(arrayOf("", ""))
    printArrOfArr(grp4)
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
}

fun printArrOfArr(matrix: List<List<String>>) {
    matrix.forEach { arr ->
        arr.forEach { print("$it ") }
        println()
    }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    var sol = ArrayList<List<String>>()
    for (i in 0 until strs.size - 1) {
        if (strs[i] == "-1") continue
        var l = arrayListOf(strs[i])
        for (j in i + 1 until strs.size) {
            if (strs[j] == "-1") continue
            if (isAnagram(strs[i], strs[j])) {
                l.add(strs[j])
                strs[j] = "-1"
            }
        }
        strs[i] = "-1"
        sol.add(l)
    }
    if (strs[strs.size - 1] != "-1") sol.add(listOf(strs[strs.size - 1]))
    return sol
}

fun isAnagram(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false
    var hashMap = HashMap<Char, Int>()
    for (s in s1) {
        if (hashMap.containsKey(s)) hashMap[s] = hashMap[s]!! + 1
        else hashMap[s] = 1
    }
    for (s in s2) {
        if (hashMap.containsKey(s)) {
            hashMap[s] = hashMap[s]!! - 1
            if (hashMap[s]!! < 0) return false
        } else return false
    }
    return true
}
