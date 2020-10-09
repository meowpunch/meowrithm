# from itertools import chain
from collections import defaultdict


class Node:
    def __init__(self, char, length=None, data=None):
        self.char = char
        self.data = None
        self.children = {}
        # length값을 저장할 dictionary. 코드를 간소화하려고 defaultdict을 사용해
        # 인자값이 없으면 0을 리턴하도록 했다.
        self.length = defaultdict(int)


class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self, string):
        node = self.head
        node.length[len(string)] += 1
        for char in string:
            if char not in node.children:
                node.children[char] = Node(char)
            # children Node의 length 변수에 [문자열 길이] += 1을 해줬다.
            # 해당 노드를 거쳐가는 문자열 중 길이가 len(string)인 것의 개수를 저장한 것.
            node.children[char].length[len(string)] += 1
            node = node.children[char]
        node.data = string

    def start_with(self, prefix, length):
        node = self.head
        for char in prefix:
            if char in node.children:
                node = node.children[char]
            else:
                return 0
        # prefix의 마지막 노드에서 length변수를 확인해
        # 해당 노드를 거쳐간 문자열 중 길이가 length인 것의 개수를 반환한다.
        return node.length[length]


def solution(words, queries):
    answer = []
    front = Trie()
    back = Trie()
    for word in words:
        front.insert(word)
        back.insert(word[::-1])
    for word in queries:
        # 전부 ?일 경우 - 문자열 길이만 일치하면 된다
        if word == "?" * len(word):
            answer.append(front.head.length[len(word)])

        # 맨 앞 글자가 ?인 경우는 역방향 트라이를 사용했다
        elif word[0] == "?":
            prefix = word[::-1].split("?")[0]
            answer.append(back.start_with(prefix, len(word)))
        else:
            prefix = word.split("?")[0]
            answer.append(front.start_with(prefix, len(word)))

    return answer

if __name__ == '__main__':
    sol = solution(words=["frodo", "front", "frost", "frozen", "frame", "kakao"],
                   queries=["fro??", "????o", "fr???", "fro???", "pro?", "pro??????"])
    print(sol)
