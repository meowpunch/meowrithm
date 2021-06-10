class Solution:
    """
    procedure backtrack(c) is
        if reject(P, c) then return
        if accept(P, c) then output(P, c)
        s ← first(P, c)
        while s ≠ NULL do
            backtrack(s)
            s ← next(P, s)
    """

    def backtracking(self, n: int) -> List[str]:
        result = []

        def explore(x, balance, count):
            # accept
            if len(x) == 2 * n:
                result.append(x)

            # call recursion
            if balance > 0:
                explore(x + ")", balance - 1, count)
            if count != n:
                explore(x + "(", balance + 1, count + 1)

        explore("", 0, 0)

        return result

    def generateParenthesis(self, n: int) -> List[str]:
        return self.backtracking(n)