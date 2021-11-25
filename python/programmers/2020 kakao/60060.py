import functools


def match(target, query):
    """
        query 와 target 이 매칭인가? True/False
    """
    if len(query) != len(target):
        return False

    result = True
    for idx, q_c in enumerate(query):
        if q_c == '?':
            continue
        elif q_c != target[idx]:
            return False

    return result


def execute(query, data):
    return sum(list(map(functools.partial(match, query=query), data)))


def solution(words, queries):
    answer = map(functools.partial(execute, data=words), queries)

    return list(answer)


if __name__ == '__main__':
    sol = solution(words=["frodo", "front", "frost", "frozen", "frame", "kakao"],
                   queries=["fro??", "????o", "fr???", "fro???", "pro?", "pro??????"])
    print(sol)
