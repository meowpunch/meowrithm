def divide(w):
    u, v = '', ''
    for i in range(1, len(w) + 1):
        if isBalanced(w[:i]):
            u = w[:i]
            v = w[i:]
            break

    if u == '' and v == '':
        raise ValueError
    return u, v


def isCorrect(s):
    count = 0
    for i in range(len(s)):
        if count < 0:
            return False

        if s[i] == '(':
            count += 1
        else:
            count -= 1

    if count == 0:
        return True
    else:
        raise ValueError


def isBalanced(s):
    a = s.replace('(', '')
    b = s.replace(')', '')
    # print("a: {}, b: {}".format(a, b))
    return len(a) == len(b)


def reverse(s):
    reversed_str = ""
    for ch in s:
        if ch == "(":
            reversed_str += ")"
        elif ch == ")":
            reversed_str += "("
    return reversed_str


def recursion(w):
    # print("recursion: ", w)
    if w == "":
        return ""

    u, v = divide(w)
    # print("u: {}, v: {}".format(u, v))

    if isCorrect(u):
        return u + recursion(v)
    else:
        temp_str = u[1:len(u) - 1]
        revered_str = reverse(temp_str)
        print(temp_str)
        print(revered_str)
        return "(" + recursion(v) + ")" + revered_str


def solution(p):
    if isCorrect(p):
        return p
    else:
        return recursion(p)


if __name__ == '__main__':
    sol = solution(p='(()())()') # '()))((()')
    print(sol)
