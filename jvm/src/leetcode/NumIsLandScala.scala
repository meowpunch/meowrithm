package leetcode

object NumIsLandScala {
  def recursive

  def numIslands(grid: Array[Array[Char]]): Int = {
    val ds: Vector[(Int, Int)] = Vector((0, 1), (0, -1), (1, 0), (-1, 0))
    val (height, width) = (grid.size, grid.head.size)

    def isValid(r: Int, c: Int): Boolean =
      0 <= r && r < height && 0 <= c && c < width && grid(r)(c) == '1'


    def dfs(r: Int, c: Int): Unit = {
      grid(r)(c) = '0'

      for {
        d <- ds
        val (nr, nc) = (r + d._1, c + d._2)
        if isValid(nr, nc)
      } dfs(nr, nc)
    }

    var count = 0

    for {
      i <- 0 until height
      j <- 0 until width
      if grid(i)(j) == '1'
    } {
      dfs(i, j)
      count += 1
    }

    count
  }
}
