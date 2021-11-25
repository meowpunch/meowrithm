class Solution:

    @staticmethod
    def chunks_zero(lst: List[int]):
        # first and last chunked zero * 2

        count = 0
        flag = 0

        for idx, ele in enumerate(lst):
            if idx == 0 and ele == 1:
                flag = 1

            if ele == 0:
                count += 1
            elif count == 0:
                continue
            else:
                if flag == 0:
                    # first
                    flag = 1
                    yield count * 2
                else:
                    yield count
                count = 0

        if count > 0:
            # last
            yield count * 2

    def maxDistToClosest(self, seats: List[int]) -> int:
        # [1,0,0,0,1,0,1] -> [3,1]

        chunked = list(self.chunks_zero(seats))
        return (max(chunked) + 1) // 2
