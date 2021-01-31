package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Balanced Brackets
 *
 * */

fun main(){
    var bal = balancedBrackets("([])(){}(())()()")
    println(bal)
}

//Time complexity O(n)
//Space Complexity O(n)
fun balancedBrackets(str: String): Boolean {
    var stack = ArrayList<Char>()
    var map = mutableMapOf<Char, Char>(
        ']' to '[',
        ')' to '(',
        '}' to '{'
    )
    for(i in str){
        if(map.contains(i)){
            if(stack.isEmpty()) return false
            var pop = stack.removeAt(stack.size-1)
            if(pop!=map[i]) return false
        }else if(i == '(' || i=='[' || i == '{')stack.add(i)

    }
    if(stack.isNotEmpty()) return false
    return true
}





