import java.util.ArrayDeque

class Node(val value: Int, val left: Node?, val right: Node?)

fun search(valueToFind: Int, root: Node): Node? = innerSearch(valueToFind,listOf(root))

private tailrec fun innerSearch(valueToFind: Int, queue:List<Node>):Node? {
    val node = queue.firstOrNull()
       if (node == null || node.value == valueToFind){
           return node
        }

    val nextQueue = queue.subList(1,queue.size) +
        (node.left?.let(::listOf) ?: emptyList()) +
        (node.right?.let(::listOf) ?: emptyList())

    return innerSearch(valueToFind, nextQueue)

}
fun main() {
    // 例として簡単な二分木を作成
    val tree = Node(
        1,
        Node(2, Node(4, null, null), Node(5, null, null)),
        Node(3, Node(6, null, null), Node(7, null, null))
    )

    val result = search(5, tree)
    if (result != null) {
        println("Node found: ${result.value}")
    } else {
        println("Node not found.")
    }
}

