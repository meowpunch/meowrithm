class Solution:
    def bagOfTokensScore(self, tokens: List[int], P: int) -> int:
        tokens.sort()  # O(nlog n)

        # visited = [False for _ in range(n)]
        score = 0

        # 방문할게 있으면 들어감 O(n)
        while tokens:
            # print('1. ',tokens, P)

            # P로 최대한 score를 얻음
            while tokens and P >= tokens[0]:
                P -= tokens[0]
                tokens = tokens[1:]
                score += 1

            # print('2.', tokens, P)
            # score을 팔아 하나라도 사면 손해는 아님 (P 남김)
            if score > 0 and len(tokens) > 2:
                P += tokens[-1]
                tokens = tokens[:-1]
                score -= 1
            else:
                break

        return score
