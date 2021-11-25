# 양수 값인 소행성들은 오른쪽에 자신보다 크거나 같은 음수가 있으면 사라짐
# 음수 값인 소행성들은 왼쪽에 자신보다 크거나 같은 양수가 있으면 사라짐

from typing import List


class Solution:
    def asteroidCollision(self, asteroids):

        # 왼쪽으로 사는 애들 left_survival 음수값만 저장
        # 오른쪽 사는 애들 right_survival

        n = len(asteroids)

        # 왼쪽 오른쪽 살아남는 행성들 (왼쪽에는 음수, 오른쪽에는 양수만 가능)
        left, right = [], []

        for asteroid in asteroids:
            if asteroid > 0:
                right.append(asteroid)

            else:
                # right 이 비어있을때,
                # 폭파될때 까지
                left.append(asteroid)
                size = abs(asteroid)

                while right:
                    if size > right[-1]:
                        right.pop(-1)
                    elif size == right[-1]:
                        right.pop(-1)
                        left.pop(-1)
                        break
                    else:
                        # size < right[-1]
                        left.pop(-1)
                        break

        return left + right

    def asteroidCollision2(self, asteroids: List[int]) -> List[int]:
        # TODO: revise
        # max_val, max_idx i번째까지 소행성들에서 살아남은 소행성들 중 최대값과 인덱스?
        # i번째 소행성이 양수라면, 무조건 살고
        # i번째 소행성이 음수라면, 어디까지 부실 수 있는가?
        # max_val보다 절대값이 크면 다 부시고 혼자 남음
        # max_val이랑 절대값이 같으면 max_val까지 부시고 자기도 부서짐
        # max_val보다 절대값이 작으면 어디까지 부실까 찾아야됨 (방법 없을까?)

        n = len(asteroids)
        # if n == 1:
        #     return asteroids

        survival = []
        max_val = -1001
        max_idx = -1
        last_left_idx = -1

        for i in range(0, n):
            # print(survival, max_val, max_idx, last_left_idx)
            asteroid = asteroids[i]

            if asteroid > 0:
                # 최대값 갱신
                if asteroid > max_val:
                    max_val = asteroid
                    max_idx = i

                survival.append(asteroid)
            else:
                if max_val < 0:
                    survival.append(asteroid)
                    last_left_idx = i
                    continue

                size = abs(asteroid)
                if size > max_val:
                    # print(survival[:last_left_idx + 1].append(asteroid))
                    survival = survival[:last_left_idx + 1] + [asteroid]
                    max_val = -1001
                    max_idx = -1
                    last_left_idx = i
                elif size == max_val:
                    survival = survival[:max_idx]
                    last_left_idx = i
                else:
                    # size보다 같거나 큰 것이 나오는 위치를 찾는다.
                    # exploded_count = 0 # -1

                    while True:
                        # print(survival)
                        target = survival[-1]

                        if size > target:
                            survival.pop(-1)
                            pass
                        elif size == target:
                            survival.pop(-1)
                            break
                        else:
                            break

        return survival


if __name__ == '__main__':
    sol = Solution().asteroidCollision(asteroids=[10, 2, -5])
    print(sol)

    sol = Solution().asteroidCollision(asteroids=[-2, -1, 1, 2])
    print(sol)

    sol = Solution().asteroidCollision(asteroids=[-2, -2, 1, -2])
    print(sol)

    sol = Solution().asteroidCollision(asteroids=[8, -8])
    print(sol)

    sol = Solution().asteroidCollision(asteroids=[-2, 1, -2, -1])
    print(sol)
