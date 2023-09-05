from collections import deque


class Solution:
    def timeTaken(self, arrival: List[int], state: List[int]) -> List[int]:
        n = len(arrival)

        arrival_dictionary = {}
        for ip, it in enumerate(arrival):
            if it not in arrival_dictionary:
                arrival_dictionary[it] = [ip]
            else:
                arrival_dictionary[it] += [ip]

        candidates = {
            0: deque(),  # enter candidates
            1: deque()  # exit candidates
        }

        # -1: not used, 0: enter, 1: exit
        previous_usage = -1

        answer = [-1] * n
        t = 0
        while candidates[0] or candidates[1] or t <= n:
            # gather people in the same arrival time
            if t in arrival_dictionary:
                for ip in arrival_dictionary[t]:
                    candidates[state[ip]].appendleft(ip)

            # decide who leaves
            if previous_usage == -1 or previous_usage == 1:
                if candidates[1]:
                    previous_usage = 1
                    answer[candidates[1].pop()] = t
                elif candidates[0]:
                    previous_usage = 0
                    answer[candidates[0].pop()] = t
                else:
                    previous_usage = -1

            else:
                if candidates[0]:
                    previous_usage = 0
                    answer[candidates[0].pop()] = t
                elif candidates[1]:
                    previous_usage = 1
                    answer[candidates[1].pop()] = t
                else:
                    previous_usage = -1

            t += 1

        return answer


if __name__ == '__main__':
    print([1, 2, 3][0:])
    print([None] * 5)
