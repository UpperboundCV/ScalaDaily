package longestSubstring

object LongestSubStringSolver {
  def isUnique(str: String): Boolean = {
    (0 to str.size - 1).forall { i =>
      str.filter { letter => letter == str(i) }.size == 1
    }
  }
  def getSubStringWithLength(str: String, length: Int): Seq[String] = {
    (0 to str.size - length).map { i => str.substring(i, length + i) }
  }
  def uniqueSubstringLength(str: String): Seq[Int] = {
    (str.size to 1 by -1).filter { length =>
      (getSubStringWithLength(str, length)
        map isUnique)
        .contains(true)
    }
  }
  def lengthOfLongestSubstring(str: String): Int =
    str match {
      case str if str == "" => 0
      case _                => uniqueSubstringLength(str).max
    }
}
