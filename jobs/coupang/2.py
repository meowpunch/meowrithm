from datetime import datetime, timedelta


def convert_str_to_date(str_date):
    return datetime.strptime(str_date, '%m/%d %H:%M:%S')


def convert(c):
    s = c.split(' ')
    return convert_str_to_date(" ".join(s[:2])), int(s[2])


def solution(n, customers):
    converted = list(map(convert, customers))
    print(converted)

    kiosks = [datetime(1, 1, 1, 0, 0) for _ in range(n)]
    counts = [0 for _ in range(n)]

    while len(converted) > 0:
        customer = converted[0]
        converted = converted[1:]
        is_pass = False

        for idx, k in enumerate(kiosks):
            if k < customer[0]:
                is_pass = True
                kiosks[idx] = customer[0] + timedelta(minutes=customer[1])
                counts[idx] += 1

        if not is_pass:
            min_i = kiosks.index(min(kiosks))
            kiosk[]

    return 0


if __name__ == '__main__':
    sol = solution(3, [
        "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13",
        "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"])
    print(sol)
