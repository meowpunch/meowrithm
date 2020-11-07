import math


def divide_sum(nums: List[int], divisor):
    return sum(map(lambda n: math.ceil(n / divisor), nums))


def binary_search(str_num: int, end_num: int, nums: List[int], threshold: int):
    #  Find the smallest divisor such that the result mentioned above is less than or equal to threshold

    if str_num >= end_num:
        return end_num

    mid_num = (str_num + end_num) // 2

    x = divide_sum(nums, mid_num)

    if threshold < x:
        # mid_num is inproper divisor
        return binary_search(mid_num + 1, end_num, nums, threshold)
    elif threshold >= x:
        # mid_num is proper divisor
        # but there can be more smaller divisor.
        return binary_search(str_num, mid_num, nums, threshold)


class Solution:

    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        size = len(nums)

        # divisor <= max(nums)
        max_num = max(nums)

        # binary search
        return binary_search(1, max_num, nums, threshold)
