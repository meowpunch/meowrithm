# !/bin/python3

#
# Complete the 'findReviewScore' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING review
#  2. STRING_ARRAY prohibitedWords
#
import re


#
#   find index of prohibitedword (n)
#
def findReviewScore(review, prohibitedWords):
    review = review.lower()
    indices = []
    for prohibitedWord in prohibitedWords:
        for i in re.finditer(prohibitedWord, review):
            indices.append((i.start(), i.end()))

    sorted_indices = sorted(indices, key=lambda kv: kv[0])

    score = 0
    n = len(sorted_indices)
    N = len(review)

    if n == 0:
        return N

    pre_idx = 0
    # Greedy
    for start, end in sorted_indices:
        score = max(score, end - 1 - pre_idx)
        pre_idx = start + 1

    score = max(score, N - pre_idx)

    return score


if __name__ == '__main__':
    print(findReviewScore("abcde", ["bc"]) == 3)
    print(findReviewScore("abcdefghi", ["bc", "gh"]) == 5)
    print(findReviewScore("abcde", ["bc"]) == 3)
    print(findReviewScore("aabbbcccc", ["b"]) == 4)
