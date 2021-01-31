package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Suffix Trie Construction
 *
 * */

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>()
)

class SuffixTrie(str: String) {
    val endSymbol = '*'
    var root = TrieNode()

    init { populate(str) }

    //Time complexity O(n^2)
    //Space Complexity O(n^2)
    fun populate(str: String) {
        for(i in 0 until str.length){
            var c1 = str[i]
            if(!root.children.contains(c1)){
                root.children[c1] = TrieNode()
            }
            var parent = root.children[c1]
            for(j in i+1 until str.length){
                var c2 = str[j]
                if(!parent!!.children.contains(c2)){
                    parent.children[c2] = TrieNode()
                }
                parent = parent.children[c2]
            }
            parent!!.children[endSymbol] = TrieNode()
        }
    }


    //Time complexity O(n) - n is length of string
    //Space Complexity O(1)
    fun contains(str: String): Boolean {
        var parent : TrieNode?  = root
        for(s in str){
            if(!parent!!.children.contains(s)) return false
            parent = parent!!.children[s]
        }
        if(parent!!.children.contains(endSymbol)) return true
        return false
    }
}

