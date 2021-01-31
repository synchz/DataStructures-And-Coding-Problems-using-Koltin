package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Phone Number Mnemonics
 *
 * */

//Time complexity O(4^n * n)
//Space Complexity O(4^n * n)
fun phoneNumberMnemonics(phoneNumber: String): List<String> {
    var sol = ArrayList<String>()
    if(phoneNumber.isEmpty()) return sol
    var arr = arrayOf("0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz")

    fun genPerm(pos:Int, list:ArrayList<Char>){
        if(pos == phoneNumber.length){
            sol.add(list.joinToString(""))
            return
        }
        for(i in arr[phoneNumber[pos].toInt()-'0'.toInt()]){
            var newList = ArrayList(list)
            newList.add(i)
            genPerm(pos+1, newList)
        }
    }
    genPerm(0, ArrayList<Char>())
    return sol
}

