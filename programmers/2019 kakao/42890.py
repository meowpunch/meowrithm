import itertools


def check_unique(rows: list):
    return len(rows) == len(set(tuple(row) for row in rows))


def check_minimal(combination, candidates):
    flag = True
    for candidate in candidates:
        if set(candidate).issubset(combination):
            flag = False
    return flag


def filter_rows(rows: list, combination: tuple):
    def filter_row(row):
        filtered_row = []
        for idx in combination:
            filtered_row.append(row[idx])
        return filtered_row

    filtered = list(map(filter_row, rows))
    return filtered


def solution(relation):
    column_size = len(relation[0])
    answer = 0
    candidates = []

    for size in range(column_size+1):
        combinations = itertools.combinations([i for i in range(column_size)], size)
        for combination in combinations:
            minimal = check_minimal(combination, candidates)
            if len(combination) > 0 and minimal:
                filtered = filter_rows(relation, combination)
                unique = check_unique(filtered)
                if unique:
                    answer += 1
                    candidates.append(combination)
                    # print("{} {} {} {}".format(combination, minimal, unique, candidates))

    return answer


if __name__ == '__main__':
    sol = solution(
        relation=[["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"],
                  ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]
    )
    print(sol)
