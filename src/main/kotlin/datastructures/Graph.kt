package datastructures

fun main() {
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
    println("BFS of graph")
    myGraph.performBfs('2').forEach { print("$it ") }
    println("DFS of graph")
    myGraph.performDfs('2').forEach { print("$it ") }

    var cityGraph = AdjacentListGraphWithWeight<Int>()
    cityGraph.apply {
        addVertex(1)
        addVertex(2)
        addVertex(3)
        addVertex(4)
        addVertex(5)
        addVertex(6)
        addEdgeDirected(1, 2, 2)
        addEdgeDirected(1, 3, 4)
        addEdgeDirected(2, 4, 7)
        addEdgeDirected(2, 3, 1)
        addEdgeDirected(3, 5, 3)
        addEdgeDirected(4, 6, 1)
        addEdgeDirected(5, 4, 2)
        addEdgeDirected(5, 6, 5)
    }.let {
        println("\nGraph")
        it.printGraph()
        it
    }.let { graph ->
        println("\nDjKistra")
        graph.shortestPathDjkistra(1).invoke(1, 6)?.forEach { print("$it ->") }
        graph
    }.let { graph ->
        println("\nBellmanFord")
        graph.shortestPathBellmanFord(1).invoke(1, 6)?.forEach { print("$it ->") }
        graph
    }
}

class AdjacentListGraph<T> {

    private var adjacencyList: HashMap<T, ArrayList<T>> = HashMap()

    fun addVertex(node: T) {
        if (!adjacencyList.containsKey(node))
            adjacencyList[node] = ArrayList()
    }

    fun addEdge(node1: T, node2: T) {
        adjacencyList[node1] = (adjacencyList[node1] ?: ArrayList()).apply { add(node2) }
        adjacencyList[node2] = (adjacencyList[node2] ?: ArrayList()).apply { add(node1) }
    }

    fun addEdgeDirected(node1: T, node2: T) {
        adjacencyList[node1] = (adjacencyList[node1] ?: ArrayList()).apply { add(node2) }
    }

    fun performBfs(node: T): Array<T> {
        return LinkedHashSet<T>().let { visitedBFSNodeSet ->
            fun bfs(node: T) {
                var queueList = ArrayList<T>()
                queueList.add(node)
                visitedBFSNodeSet.add(node)
                while (queueList.size != 0) {
                    adjacencyList[queueList.removeFirst()]?.let {
                        for (value in it) {
                            if (!visitedBFSNodeSet.contains(value)) {
                                queueList.add(value)
                                visitedBFSNodeSet.add(value)
                            }
                        }
                    }
                }
            }
            bfs(node)
            visitedBFSNodeSet.toArray() as Array<T>
        }
    }

    fun performDfs(node: T): Array<T> {
        return LinkedHashSet<T>().let { visitedDFSNodeSet ->
            fun dfs(node: T) {
                visitedDFSNodeSet.add(node)
                adjacencyList[node]?.let {
                    for (value in it) {
                        if (!visitedDFSNodeSet.contains(value)) {
//                    Write logic here if want to track backtracking
                            visitedDFSNodeSet.add(value)
                            dfs(value)
                        }
                    }
                }
                return
            }
            dfs(node)
            visitedDFSNodeSet.toArray() as Array<T>
        }
    }

    fun printGraph() {
        for (key in adjacencyList.keys) {
            print("$key -> ")
            adjacencyList[key]?.forEach { print("$it ") }
            println()
        }
    }
}


class AdjacentListGraphWithWeight<T> {
    private var adjacencyList: HashMap<T, ArrayList<Pair<T, Int>>> = HashMap()
    fun addVertex(node: T) {
        if (!adjacencyList.containsKey(node))
            adjacencyList[node] = ArrayList()
    }

    fun addEdge(node1: T, node2: T, weight: Int) {
        adjacencyList[node1] = (adjacencyList[node1] ?: ArrayList()).apply { add(Pair(node2, weight)) }
        adjacencyList[node2] = (adjacencyList[node2] ?: ArrayList()).apply { add(Pair(node1, weight)) }
    }

    fun addEdgeDirected(node1: T, node2: T, weight: Int) {
        adjacencyList[node1] = (adjacencyList[node1] ?: ArrayList()).apply { add(Pair(node2, weight)) }
    }

    fun performBfs(node: T): Array<T> {
        return LinkedHashSet<T>().let { visitedBFSNodeSet ->
            fun bfs(node: T) {
                var queueList = ArrayList<T>()
                queueList.add(node)
                visitedBFSNodeSet.add(node)
                while (queueList.size != 0) {
                    adjacencyList[queueList.removeFirst()]?.let {
                        for (value in it) {
                            if (!visitedBFSNodeSet.contains(value)) {
                                queueList.add(value.first)
                                visitedBFSNodeSet.add(value.first)
                            }
                        }
                    }
                }
            }
            bfs(node)
            visitedBFSNodeSet.toArray() as Array<T>
        }
    }

    fun performDfs(node: T): Array<T> {
        return LinkedHashSet<T>().let { visitedDFSNodeSet ->
            fun dfs(node: T) {
                visitedDFSNodeSet.add(node)
                adjacencyList[node]?.let {
                    for (value in it) {
                        if (!visitedDFSNodeSet.contains(value)) {
//                    Write logic here if want to track backtracking
                            visitedDFSNodeSet.add(value.first)
                            dfs(value.first)
                        }
                    }
                }
            }
            visitedDFSNodeSet.toArray() as Array<T>
        }
    }

    private fun printShortestPathToNode(
        startNode: T,
        endNode: T,
        calculateShortestPath: HashMap<T, Pair<T, Int>>
    ): ArrayList<T>? {
        var pathArray = ArrayList<T>()
        var currentNode = endNode
        pathArray.add(0, currentNode)
        while (currentNode != startNode) {
            if (!calculateShortestPath.containsKey(currentNode)) return null
            currentNode = calculateShortestPath[currentNode]!!.first
            pathArray.add(0, currentNode)
        }
        return pathArray
    }

    fun shortestPathDjkistra(startNode: T): (T, T) -> ArrayList<T>? {
        var visitedDjkistraNodeSet: HashSet<T> = LinkedHashSet()
        var shortestPath = HashMap<T, Pair<T, Int>>().let { calculatedShortestPathDjKistra ->
            calculatedShortestPathDjKistra[startNode] = Pair(startNode, 0)
            fun findNodeWithLeastWeight(): T? {
                var min: Int? = null
                var minNode: T? = null
                calculatedShortestPathDjKistra.forEach { (key, value) ->
                    if (!visitedDjkistraNodeSet.contains(key) && (null == min || min!! > value.second)) {
                        min = value.second
                        minNode = key
                    }
                }
                return minNode
            }

            fun findShortestPathUsingDjkistra(startNode: T) {
                visitedDjkistraNodeSet.add(startNode)
                adjacencyList[startNode]?.let {
                    for (nodeSet in it) {
                        if (!visitedDjkistraNodeSet.contains(nodeSet.first) && (!calculatedShortestPathDjKistra.containsKey(
                                nodeSet.first
                            ) ||
                                    calculatedShortestPathDjKistra[nodeSet.first]!!.second > (nodeSet.second + (calculatedShortestPathDjKistra[startNode]?.second
                                ?: 0))
                                    )
                        )
                            calculatedShortestPathDjKistra[nodeSet.first] = Pair(
                                startNode,
                                nodeSet.second + (calculatedShortestPathDjKistra[startNode]?.second ?: 0)
                            )
                    }
                }
                var leastNode: T = findNodeWithLeastWeight() ?: return
                findShortestPathUsingDjkistra(leastNode)
            }
            findShortestPathUsingDjkistra(startNode)
            calculatedShortestPathDjKistra
        }
        return fun(startNode: T, endNode: T): ArrayList<T>? {
            return printShortestPathToNode(startNode, endNode, shortestPath)
        }

    }

    fun shortestPathBellmanFord(startNode: T): (T, T) -> ArrayList<T>? {
        var shortestPath = HashMap<T, Pair<T, Int>>().let { calculatedShortestPathBellmanFord ->
            calculatedShortestPathBellmanFord[startNode] = Pair(startNode, 0)
            var count = adjacencyList.size
            while (count-- > 0) {
                adjacencyList.forEach { (key, value) ->
                    if (calculatedShortestPathBellmanFord.containsKey(key)) {
                        var currentNodeWeight = calculatedShortestPathBellmanFord[key]!!.second
                        value.forEach { (node, weight) ->
                            if (!calculatedShortestPathBellmanFord.containsKey(node) ||
                                (currentNodeWeight + weight) < calculatedShortestPathBellmanFord[node]!!.second
                            ) {
                                calculatedShortestPathBellmanFord[node] = Pair(key, currentNodeWeight + weight)
                            }
                        }
                    }
                }
            }
            calculatedShortestPathBellmanFord
        }
        return fun(startNode: T, endNode: T): ArrayList<T>? {
            return printShortestPathToNode(startNode, endNode, shortestPath)
        }
    }

    fun printGraph() {
        for (key in adjacencyList.keys) {
            print("$key -> ")
            adjacencyList[key]?.forEach { print("(${it.first},${it.second}) ") }
            println()
        }
    }
}