import sys

sys.setrecursionlimit(10 ** 6)


class Tree:
    def __init__(self, nodes: list):
        self.value = max(nodes, key=lambda x: x[1])
        left_nodes = list(filter(lambda node: node[0] < self.value[0], nodes))
        right_nodes = list(filter(lambda node: node[0] > self.value[0], nodes))

        if left_nodes != []:
            self.left = Tree(left_nodes)
        else:
            self.left = None

        if right_nodes != []:
            self.right = Tree(right_nodes)
        else:
            self.right = None


preorder = []
postorder = []


def order(node):
    preorder.append(node.value)

    if node.left is not None:
        order(node.left)

    if node.right is not None:
        order(node.right)

    postorder.append(node.value)


def solution(nodeinfo):
    answer = []

    root = Tree(nodeinfo)
    order(root)

    def get_index(x):
        return nodeinfo.index(x) + 1

    answer.append(list(map(get_index, preorder)))
    answer.append(list(map(get_index, postorder)))
    return answer


if __name__ == '__main__':
    sol = solution([[5, 3], [11, 5], [13, 3], [3, 5], [6, 1], [1, 3], [8, 6], [7, 2], [2, 2]])
    print(sol)
