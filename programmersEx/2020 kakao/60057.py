# 문자열 압축


# def calculate(sliced: list):
#     total_count = len(sliced[0])
#     duplicated = False
#     list_size = len(sliced)
#     for idx in range(1, list_size):
#         if sliced[idx] == sliced[idx-1]:
#             if not duplicated:
#                 total_count += 1
#             duplicated = True
#         else:
#             total_count += len(sliced[idx])
#             duplicated = False
#
#     return total_count
#
#
# def slice_string(string: str, size: int):
#     sliced = []
#     s = 0
#     while s < len(string):
#         if s+size > len(string):
#             sliced.append(string[s:])
#             break
#
#         sliced.append(string[s:s + size])
#         s += size
#     return sliced
#
#
# def solution(s):
#     length = len(s)
#     answer = length
#     for i in range(1, length):
#         sliced = slice_string(s, i)
#
#         calculated = calculate(sliced)
#         print(sliced, calculated, i)
#         if answer > calculated:
#             answer = calculated
#
#     return answer

# def calculate(string, size):
#     temp = ""
#     length = len(string)
#     idx = 0
#     hit = 0
#     count = 0
#     while length > idx:
#         if length < idx + size:
#             if hit:
#                 count += len(str(hit + 1))
#                 count += len(temp)
#             else:
#                 count += len(temp)
#
#             hit = 0
#         elif length == idx + size:
#             pass
#         else:
#             if temp == string[idx: idx+size]:
#                 hit += 1
#             else:
#                 if hit:
#                     count += len(str(hit + 1))
#                     count += len(temp)
#                 else:
#                     count += len(temp)
#
#                 hit = 0
#
#         temp = string[idx: idx+size]
#         idx += size
#
#
#     return count
#
#
# def solution(s):
#     length = len(s)
#     answer = length
#
#     for i in range(1, int(length / 2)):
#         calculated = calculate(s, i)
#
#         print(calculated, i)
#         if answer > calculated:
#             answer = calculated
#
#     return answer


#
def solution(s):
    results = []
    resStr = ""

    # 없으면 5번 틀림
    if len(s) == 1:
        return 1

    for length in range(1, len(s) // 2 + 1):

        count = 1
        tempStr = s[:length]
        for i in range(length, len(s), length):
            if s[i:i + length] == tempStr:
                count += 1
            else:
                if count == 1:
                    count = ""
                resStr += str(count) + tempStr
                tempStr = s[i:length+i]
                count = 1

        if count == 1:
            count = ""
        resStr += str(count) + tempStr
        results.append(len(resStr))
        resStr = ""

    return min(results)


if __name__ == '__main__':
    sol = solution(s="ababcdcdababcdcd")
    print(sol)
