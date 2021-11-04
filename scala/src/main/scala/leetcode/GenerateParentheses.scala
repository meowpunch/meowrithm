package leetcode

object GenerateParentheses {
  /*
        f(0) - ""
        f(1) - (f(0)) - "()"
        f(2) - (f(0)) + f(1), (f(1))
        f(3) - ... (f(1)) + f(1)

        f(n) - ( f(k) ) + f(n-k-1), 0 <= k < n
    */
  def generateParenthesis(n: Int): List[String] =
      if (n == 0) List("")
      else
        for {
          k <- (0 until n).toList
          a <- generateParenthesis(k)
          b <- generateParenthesis(n - k - 1)
        } yield "(" + a + ")" + b
}
