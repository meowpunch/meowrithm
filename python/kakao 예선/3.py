import functools


def filter_query(q):
    return q.replace(" and", "").split(" ")


def execute(query, info):
    # print('query: ', query)
    count = 0
    for row in info:
        # print('row: ', row)
        flag = 0
        for idx, where in enumerate(query):

            if where == "-":
                continue
            # 점수 경우
            elif idx == 4:
                if int(row[idx]) >= int(where):
                    # print(row[idx], where)
                    continue
                else:
                    flag = 1
                    break
            else:
                if where == row[idx]:
                    continue
                else:
                    flag = 1
                    break

        if flag == 0:
            count += 1

    return count


def solution(info, query):
    mapped_query = list(map(filter_query, query))
    mapped_info = list(map(lambda i: i.split(" "), info))

    result = map(functools.partial(execute, info=mapped_info), mapped_query)
    # print(mapped_query)
    # print(mapped_info)

    return list(result)


if __name__ == '__main__':
    sol = solution(
        info=["java backend junior pizza 150", "python frontend senior chicken 210",
              "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
              "python backend senior chicken 50"],
        query=["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
               "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
               "- and - and - and chicken 100", "- and - and - and - 150"]
    )
    print(sol)


