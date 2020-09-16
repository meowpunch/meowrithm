def first(s):
    return s.lower()


def second(s):
    # filtered = ""

    def isValidate(c):
        if c in 'abcdefghijklmnopqrstuvwxyz-_.1234567890':
            return True
        else:
            return False

    filtered = list(filter(lambda c: isValidate(c), s))
    return "".join(filtered)


def third(s):
    flag = 0
    removed = []
    for c in s:
        if c == '.':
            if flag == 1:
                continue
            removed.append(c)
            flag = 1
        else:
            removed.append(c)
            flag = 0

    return ''.join(removed)


def fourth(s):
    filtered = list(map(lambda c: "" if c == "." else c, [s[0], s[len(s) - 1]]))
    return filtered[0] + s[1:len(s) - 1] + filtered[1]


def fifth(s):
    if s == "":
        return "a"
    else:
        return s


def sixth(s):
    if len(s) >= 16:
        sliced = s[:15]
        return fourth(sliced)
    else:
        return s


def seventh(s):
    if len(s) <= 2:
        last_ch = s[len(s) - 1]
        while len(s) < 3:
            s = s + last_ch
        return s
    else:
        return s


def solution(new_id):
    a = first(new_id)
    print(a)
    b = second(a)
    print(b)
    c = third(b)
    print(c)
    d = fourth(c)
    print(d)
    e = fifth(d)
    f = sixth(e)
    print(f)
    g = seventh(f)

    return g


if __name__ == '__main__':
    sol = solution(new_id="...!@BaT#*..y.abcdefghijklm1234")
    print(sol)
