package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Spiral Traverse
 *
 * */

//Time Complexity = O(n)
//Space Complexity = O(n)
//Using directions approach
fun spiralTraverse(array: MutableList<MutableList<Int>>): List<Int> {
    var outList = ArrayList<Int>()
    var rowSize = array.size
    if(rowSize == 0) return listOf<Int>()
    var colSize = array[0].size
    var row=0
    var col=0
    var count =0
    var dirHoriz = 1
    var dirVert = 0
    while(count< rowSize*colSize){
        count++
        outList.add(array[row][col])
        array[row][col] = -1
        when{
            dirHoriz!=0 && dirHoriz>0 && (col+dirHoriz>=colSize || array[row][col+dirHoriz]<0)->{
                dirHoriz = 0
                dirVert = 1
            }
            dirHoriz!=0 && dirHoriz<0 && (col+dirHoriz<0 || array[row][col+dirHoriz]<0)->{
                dirHoriz = 0
                dirVert = -1
            }
            dirVert!=0 && dirVert>0 && (row+dirVert>=rowSize || array[row +dirVert][col]<0)->{
                dirHoriz = -1
                dirVert = 0
            }
            dirVert!=0 && dirVert<0 && (row+dirVert<0 || array[row+dirVert][col]<0)->{
                dirHoriz = 1
                dirVert = 0
            }
        }
        row+=dirVert
        col+=dirHoriz
    }
    return outList
}

//Time Complexity = O(n)
//Space Complexity = O(n)
fun spiralTraverseUsingIterativeApproach(array: List<List<Int>>): List<Int> {
    if(array.isEmpty()) return listOf<Int>()
    var strtRow = 0
    var strtCol = 0
    var endRow = array.size-1
    var endCol = array[0].size-1
    var outList = ArrayList<Int>()
    while(strtRow<=endRow && strtCol<=endCol){
        for(i in strtCol..endCol){
            outList.add(array[strtRow][i])
        }
        for(i in strtRow+1..endRow){
            outList.add(array[i][endCol])
        }
        if(strtRow!=endRow && strtCol!=endCol){
            for(i in endCol-1 downTo strtRow){
                outList.add(array[endRow][i])
            }
            for(i in endRow-1 downTo strtRow+1){
                outList.add(array[i][strtCol])
            }
        }
        strtRow++
        endRow--
        strtCol++
        endCol--
    }
    return outList
}

