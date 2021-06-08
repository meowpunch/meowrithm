class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = m + n - 1
        while nums2 and i >= 0:

            x = nums2.pop()

            if nums1[i] <= x:
                nums1[j] = x
            else:
                nums1[j] = nums1[i]
                nums2.append(x)
                i -= 1

            j -= 1

        if nums2:
            for k in range(len(nums2)):
                nums1[k] = nums2[k]
