package datastructures

fun main(){
    println("Graph")
    var myGraph = AdjacentListGraph<Char>()
    myGraph.addVertex('0');
    myGraph.addVertex('1');
    myGraph.addVertex('2');
    myGraph.addVertex('3');
    myGraph.addVertex('4');
    myGraph.addVertex('5');
    myGraph.addVertex('6');
    myGraph.addEdge('3', '1');
    myGraph.addEdge('3', '4');
    myGraph.addEdge('4', '2');
    myGraph.addEdge('4', '5');
    myGraph.addEdge('1', '2');
    myGraph.addEdge('1', '0');
    myGraph.addEdge('0', '2');
    myGraph.addEdge('6', '5')
    myGraph.printGraph()

}

class AdjacentListGraph<T>{

    var adjacencyList: HashMap<T, ArrayList<T>> = HashMap()

    fun addVertex(node: T){
        if(!adjacencyList.containsKey(node))
            adjacencyList[node] = ArrayList()
    }

    fun addEdge(node1 : T, node2 : T){
        adjacencyList[node1] = (adjacencyList[node1]?: ArrayList()).apply { add(node2) }
        adjacencyList[node2] = (adjacencyList[node2]?: ArrayList()).apply { add(node1) }
    }
    fun addEdgeDirected(node1 : T, node2 : T){
        adjacencyList[node1] = (adjacencyList[node1]?: ArrayList()).apply { add(node2) }
    }

    fun printGraph(){
        for(key in adjacencyList.keys){
            print("$key -> ")
            adjacencyList[key]?.forEach { print("$it ") }
            println()
        }
    }
}