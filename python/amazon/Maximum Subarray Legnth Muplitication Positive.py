#
# 1 -1 -1 -1 1 1
#
# positive(n) maximum length of subarray
# whose multiplication is equal 1, ending at n index
#
# negative(n) maximum length of subarray
# whose multiplication is equal -1, ending at n index
def maxSubarrayLength(badges):
    answer, positive, negative = 0, 0, 0

    for interested in badges:
        if interested == 1:
            positive += 1
            if negative > 0:
                negative += 1
        else:  # interested == -1
            negative, positive = positive + 1, (
                negative + 1 if negative > 0 else 0)

        answer = max(positive, answer)
    return answer


if __name__ == '__main__':
    print(maxSubarrayLength([1, -1, -1, -1, 1, 1]) == 4)
