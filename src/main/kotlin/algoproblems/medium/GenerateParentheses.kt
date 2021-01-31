package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Generate Parentheses
 *
 * */

fun generateParenthesis(n: Int): List<String> {
    var sol = ArrayList<String>()
    fun genPerm(left:Int, right:Int, arr:ArrayList<String>){
        if(left == n && right == n){
            sol.add(arr.joinToString(""))
            return
        }
        if(left!=right){
            var newArr = ArrayList(arr)
            newArr.add(")")
            genPerm(left, right+1, newArr)
        }
        if(left+1 >n) return
        var newArr = ArrayList(arr)
        newArr.add("(")
        genPerm(left+1, right, newArr)

    }
    genPerm(0, 0, ArrayList<String>())
    return sol
}

