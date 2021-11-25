from datetime import datetime, timedelta


def convert_str_to_date(str_date):
    return datetime.strptime(str_date, '%m/%d %H:%M:%S')


def convert(c):
    s = c.split(' ')
    return convert_str_to_date(" ".join(s[:2])), int(s[2])


def solution(n, customers):
    # (datetime, minutes)
    converted = list(map(convert, customers))

    kiosks = [datetime(1, 1, 1, 0, 0) for _ in range(n)]
    counts = [0 for _ in range(n)]

    while len(converted) > 0:
        print(kiosks)
        customer = converted[0]
        converted = converted[1:]

        # kiosks 를 primary queue 에 넣고 했으면 좋았을 걸.
        min_i = kiosks.index(min(kiosks))

        if kiosks[min_i] < customer[0]:
            kiosks[min_i] = customer[0] + timedelta(minutes=customer[1])
            counts[min_i] += 1
        else:
            kiosks[min_i] += timedelta(minutes=customer[1])
            counts[min_i] += 1

    print(counts)
    return max(counts)


if __name__ == '__main__':
    sol = solution(3, [
        "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13",
        "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"])
    print(sol)
