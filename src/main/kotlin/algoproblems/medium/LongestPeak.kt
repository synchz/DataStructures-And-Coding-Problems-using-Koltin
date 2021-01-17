package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Longest Peak
 *
 * */

// Time Complexity = O(N)
// Space Complexity = O(1)
fun longestPeak(a: List<Int>): Int {
    if(a.size<3) return 0
    var maxLength = 0
    var c = 0
    var isInc = true
    var isPeak = false
    for(i in 1 until a.size){
        when{
            a[i]>a[i-1] && isInc->{
                c++
                isPeak=true
            }
            a[i]<a[i-1] && isPeak ->{
                isInc = false
                c++
                if(i==a.size-1 && maxLength<c+1) maxLength = c+1
            }
            (a[i]>a[i-1] && isPeak)->{
                c++
                if(maxLength<c) maxLength = c
                c = 1
                isInc = true
                isPeak = true
            }
            ((a[i] == a[i-1]) && isPeak && !isInc)->{
                c++
                if(maxLength<c) maxLength = c
                c = 0
                isInc = true
                isPeak = false
            }
            else ->{
                c = 0
                isPeak=false
                isInc = true
            }
        }

    }
    return maxLength
}


// Time Complexity = O(N)
// Space Complexity = O(1)
fun longestPeakByDetectingPeaks(a: List<Int>): Int {
    if(a.size<3) return 0
    var m = 0
    var i=1
    while(i<a.size-1){
        if(a[i-1]<a[i] && a[i]>a[i+1]){
            var c = 3
            var j = i-1
            while(j>0 && a[j-1]<a[j]){
                j--
                c++
            }
            i+=2
            while(i<a.size && a[i-1]>a[i]){
                i++
                c++
            }
            if(c>m) m = c
        } else i++
    }
    return m
}
