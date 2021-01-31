package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * River Sizes
 *
 * */

//Time complexity O(nm)
//Space Complexity O(nm) if input list can not be mutated
fun riverSizes(matrix: MutableList<MutableList<Int>>): List<Int> {
    var sol = ArrayList<Int>()
    if(matrix.isEmpty()) return sol
    var rows = matrix.size
    var cols = matrix[0].size
    fun dfs(i:Int, j:Int) :Int{
        if(i<0 || j<0 || i>=rows || j>= cols || matrix[i][j]!=1) return 0
        var count = 1
        matrix[i][j] = -1
        count +=  dfs(i-1, j)
        count +=  dfs(i+1, j)
        count +=  dfs(i, j+1)
        count +=  dfs(i, j-1)
        return count
    }
    for(i in 0 until rows){
        for(j in 0 until cols){
            dfs(i, j).let{
                if(it>0) sol.add(it)
            }

        }
    }
    return sol
}


class AncestralTree(name: Char) {
    val name = name
    var ancestor: AncestralTree? = null
}

//Time complexity = O(d) - depth of tree
//Space Complexity = O(d)
fun getYoungestCommonAncestorExtraSpace(topAncestor: AncestralTree, descendantOne: AncestralTree, descendantTwo: AncestralTree): AncestralTree? {
    var cache = HashSet<Char>()
    var t = descendantOne.ancestor
    cache.add(descendantOne.name)
    while(t!=topAncestor || t!=null){
        if(t==descendantTwo) return t
        cache.add(t!!.name)
        t = t?.ancestor
    }
    t = descendantTwo.ancestor
    while(t!=topAncestor || t!=null){
        if(t==descendantOne || cache.contains(t!!.name)) return t
        t = t?.ancestor
    }
    return topAncestor
}

//Time complexity = O(d) - depth of tree
//Space Complexity = O(1)
fun getYoungestCommonAncestor(topAncestor: AncestralTree, descendantOne: AncestralTree, descendantTwo: AncestralTree): AncestralTree? {
    fun getDepth(a:AncestralTree?):Int{
        var c = 0
        var t = a
        while(t!=null){
            c++
            t = t?.ancestor
        }
        return c
    }
    var d1:Int = getDepth(descendantOne)
    var d2:Int = getDepth(descendantTwo)
    fun dfs(a:AncestralTree, depth:Int):AncestralTree?{
        var d = depth
        var t:AncestralTree? = a
        while(d>0){
            t = t?.ancestor
            d--
        }
        return t
    }
    fun dfsCommon(a1:AncestralTree?, a2:AncestralTree?, depth:Int):AncestralTree?{
        var t1= a1
        var t2 = a2
        var d = depth
        while(depth>0 && t1!=t2){
            t1 = t1?.ancestor
            t2 = t2?.ancestor
            d--
        }
        return t1
    }
    return if(d1>d2){
        var t =dfs(descendantOne, d1-d2)
        dfsCommon(t, descendantTwo, d2)
    }
    else{
        var t = dfs(descendantTwo, d2-d1)
        dfsCommon(t, descendantOne, d1)
    }
    return topAncestor
}
