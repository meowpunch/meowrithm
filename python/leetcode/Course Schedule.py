from functools import reduce


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        prerequisites_index = [list() for _ in range(numCourses)]

        for prerequisite in prerequisites:
            prerequisites_index[prerequisite[0]].append(prerequisite[1])

        visit = [False] * numCourses

        def traverse(course: int) -> bool:

            if not visit[course]:
                return False

            visit[course] = True

            return reduce(lambda l, r: l * r, prerequisites_index[course]) == 1

        return traverse(0)
