import java.util.ArrayDeque

class Node(val value: Int, val left: Node?, val right: Node?)

fun search(valueToFind: Int, root: Node): Node? {
   val queue = ArrayDeque<Node>()
    var node: Node? = root
    while (node != null && node.value != valueToFind){
        node.left?.let(queue::add)
        node.right?.let(queue::add)
        node = queue.poll()
    }
    return node
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
