package leetcode.kotlin

class ValidParentheses {
    /**
     *
     * -  iterate string
     * -    if open bracket push stack
     * -    else close bracket
     * -        check if top of stack match with close bracket e.g. in case of {, top bracket should be  }
     */
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        s.chars()
            .mapToObj { it.toChar() }
            .forEach {
                when (it) {
                    '{', '(', '[' -> stack.addLast(it)
                    '}', ')', ']' -> if (findOpenBracket(it) == stack.lastOrNull()) stack.removeLast() else stack.addLast(it)
                    else -> throw IllegalArgumentException()
                }
            }

        return stack.isEmpty()
    }

    private fun findOpenBracket(closeBracket: Char): Char {
        return when (closeBracket) {
            ')' -> '('
            ']' -> '['
            '}' -> '{'
            else -> throw IllegalArgumentException()
        }
    }
}