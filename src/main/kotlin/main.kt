fun main() {
    println("Hello World!")
    var hashMap = HashMap<Int, String>()
    hashMap[-3] = "Strawberry"
    hashMap[0] = "Apple"
    hashMap[-1] = "Mango"
    hashMap[3] = "Grape"
    hashMap[2] = "Orange"
    hashMap[-2] = "Liwi"
    println(hashMap.keys)
    var linkedList = ArrayList<Int>()
    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)
    linkedList.add(4)
    linkedList.forEach { print("$it ") }
    println()
    linkedList.add(1,5)
    linkedList.forEach { print("$it ") }
    println()
    var arr = arrayOf(45,12,0,-3,-1,99)
    arr.sort()
    arr.forEach { print("$it ") }

}