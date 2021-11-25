class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        n = len(arr)
        minV, maxV = arr[0], arr[n - 1]

        if k < minV:
            return k
        elif k > maxV:
            # [2, 5], 7 -> 9
            # maxV + k - (maxV - n)
            return k + n
        else:
            # [2, 3, 7], 3
            # arr[i] - (i + 1) : the number of missing values to i-th
            missNum = 0

            # O(n)
            for idx, val in enumerate(arr):
                missNum = val - (idx + 1)
                if missNum < k:
                    continue
                elif missNum >= k:
                    return val - (missNum - k + 1)

            return maxV + k - (missNum)

#         O(k * n)

#         cur = 1

#         while k > 0:
#             # missing
#             if cur not in arr:
#                 k -= 1
#                 if k == 0:
#                     return cur

#             cur += 1
