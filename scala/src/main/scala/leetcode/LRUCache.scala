package leetcode

import scala.collection.mutable

class LRUCache(_capacity: Int) {

  private val m = new mutable.LinkedHashMap[Int, Int]()

  def get(key: Int): Int = {
    m.get(key) match {
      case Some(v) =>
        m.remove(key)
        m.put(key, v)
        v
      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    if (m.contains(key)) m.remove(key)
    else if (_capacity <= m.size) m.remove(m.head._1)

    m.put(key, value)
  }
}
