package company.sap


data class Node<T>(val data: T, val children: List<Node<T>>)

/*
    check if this(QueryTree) is subset of DataTree(that)
    - find where a root of this tree is located in that tree
        - check if children of this tree is in right order same as children of that tree
        - recursive call with a pair of this child and that child
 */
infix fun <T> Node<T>.subsetOf(that: Node<T>): Boolean {
    fun helper(a: Node<T>, b: Node<T>): Boolean {
        // base case
        if (a.children.isEmpty()) return true

        val bChildrenIter = b.children.listIterator()
        val ps = a.children.fold(listOf<Pair<Node<T>, Node<T>>?>()) { acc, ac ->
            var bc: Node<T>? = null
            while (bChildrenIter.hasNext() && bc?.data != ac.data) {
                bc = bChildrenIter.next()
            }
            acc + if (bc == null) null else Pair(ac, bc)
        }

        return ps.map { p -> if (p != null) helper(p.first, p.second) else false }
            .find { !it } ?: true

    }

    val start = that.find(this)
    return if (start == null) false else helper(this, start)
}

fun <T> Node<T>.find(n: Node<T>): Node<T>? {
    if (this.data == n.data) return this
    else if (this.children.isEmpty()) return null
    else {
        for (child in this.children) {
            val x = child.find(n)
            if (x != null) return x
        }

        return null
    }
}

/*
    DataTree                QueryTree
         C                      D
       /  \                   /  \
      A    D                 F    B
         / | \
        F  E  B

 */
class DataQueryTree<T> {

    fun isValid(queryRoot: Node<T>, dataRoot: Node<T>): Boolean = queryRoot subsetOf dataRoot
}

fun main() {
    val testData = Node(
        "C", listOf(
            Node("A", emptyList()), Node(
                "D",
                listOf(Node("F", emptyList()), Node("E", emptyList()), Node("B", emptyList()))
            )
        )
    )

    val testQueries = listOf(
        Node(
            "D",
            listOf(Node("F", emptyList()), Node("B", emptyList()))
        ),
        Node(
            "D",
            listOf(Node("B", emptyList()), Node("E", emptyList()))
        ),
        Node(
            "C",
            listOf(Node("D",
                listOf(Node("E", emptyList()))))
        )
    )

    println(testData.find(Node("D", emptyList())))
    println(testData.find(Node("Z", emptyList())))

    testQueries.forEach { q -> println(DataQueryTree<String>().isValid(q, testData)) }

}