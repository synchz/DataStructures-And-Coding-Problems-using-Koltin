package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Remove Islands
 *
 * */

//Time complexity O(nm)
//Space Complexity O(nm)
fun removeIslands(matrix: MutableList<MutableList<Int>>): List<MutableList<Int>> {
    if(matrix.isEmpty()) return matrix
    var rowCount = matrix.size
    var colCount = matrix[0].size
    fun dfs(i:Int, j:Int){
        if(i<0 || j<0 || i>=rowCount || j>=colCount || matrix[i][j]!=1) return
        matrix[i][j] = -1
        dfs(i+1, j)
        dfs(i-1, j)
        dfs(i, j+1)
        dfs(i, j-1)
    }
    for(i in 0 until rowCount){
        dfs(i , 0)
        dfs(i , colCount-1)
    }
    for(i in 0 until colCount){
        dfs(0 , i)
        dfs(rowCount-1 , i)
    }
    for(i in 0 until rowCount){
        for(j in 0 until colCount){
            matrix[i][j] = if(matrix[i][j] ==-1) 1 else 0
        }
    }
    return matrix
}

