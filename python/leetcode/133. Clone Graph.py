import copy


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    # @staticmethod
    # def copy(node: 'Node') -> 'Node':
    def __init__(self):
        self.visited_nodes = {}

    def clone_graph(self, node: 'Node') -> 'Node':
        copied_node = copy.copy(node)
        # 빈노드
        if not copied_node:
            return copied_node

        self.visited_nodes[copied_node.val] = copied_node

        # 이미 방문했으면, 저장한거 채워넣음
        copied_node.neighbors = list(
            map(lambda n: self.clone_graph(n) if n.val not in self.visited_nodes.keys() else self.visited_nodes[n.val]
                , copied_node.neighbors)
        )
        return copied_node

    def cloneGraph(self, node: 'Node') -> 'Node':
        # deepcopy 는 내부도 전부 완전히 새로운 오브젝트를 만들어서 복사한다.
        new_node = copy.deepcopy(node)
        return new_node


if __name__ == '__main__':
    a = copy.copy(None)
    print(a)
