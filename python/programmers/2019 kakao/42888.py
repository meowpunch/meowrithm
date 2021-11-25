# uid 가 핵심임.
# key: value -> uid: name Dictionary 만듬

mapDict = dict()


def translate(r):
    if r[0] == 'Enter':
        return "{id}님이 들어왔습니다.".format(id=mapDict[r[1]])
    elif r[0] == 'Leave':
        return "{id}님이 나갔습니다.".format(id=mapDict[r[1]])


def transform(r: str):
    split = r.split(' ')
    if len(split) is 3:
        mapDict[split[1]] = split[2]
    return split


def solution(record: list):
    split = map(transform, record)

    # filter 에 list 걸어줘야 dictionary 가 모두 완성된 후 translate 사용
    filtered = list(filter(lambda x: x[0] != 'Change', split))
    return list(map(translate, filtered))


if __name__ == '__main__':
    solution(
        record=["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan"]
    )
