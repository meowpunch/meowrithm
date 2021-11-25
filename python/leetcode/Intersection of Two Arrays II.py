class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        don't consider the order of intersected elements.
        e.g. [1,2,3,4], [4,3,2,1] -> [1,2,3,4]

        n, m = len(nums1), len(nums2)

        time: O(n) or O(m)
        space: O(n)
        """
        n, m = len(nums1), len(nums2)
        mem = dict()
        result = list()

        for v in nums1:
            mem[v] = mem.get(v, 0) + 1

        for v in nums2:
            c = mem.get(v, 0)
            if c > 0:
                result.append(v)
                mem[v] = c - 1

        return result

