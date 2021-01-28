package longestSubstring

import scala.annotation.tailrec

object LongestSubStringHintSolver {
  def longestSubStringHintSolver(str: String): Int = {
    val strLength = str.length
    println(s"string length: ${strLength}")
    @tailrec
    def longestSubstringFinder(
        str: String,
        startIndex: Int,
        endIndex: Int,
        maxSubstring: Int
    ): Int = {
      println(s"start Index: $startIndex")
      println(s"end Index: $endIndex")
      if (startIndex < strLength - 1 && endIndex <= strLength - 1) {
        println("===========================")
        println(s"input: $str")
        val subStr = str.substring(startIndex, endIndex)
        println(s"current subString:$subStr")
        println(s"next character: ${str.charAt(endIndex)}")
        if (!subStr.contains(str.charAt(endIndex))) {
          val nextEndIndex = endIndex + 1
          println(s"next end index: $nextEndIndex")
          println(s"next subString: ${str.substring(startIndex, nextEndIndex)}")
          val mx = nextEndIndex - startIndex
          println(s"next max substring: ${Math.max(mx, maxSubstring)}")
          longestSubstringFinder(
            str,
            startIndex,
            nextEndIndex,
            Math.max(mx, maxSubstring)
          )
        } else {
          //endIndex is the index of next character to substring
          val nextStartIndex =
            startIndex + subStr.indexOf(str.charAt(endIndex)) + 1

          println(s"nextStartIndex: ${nextStartIndex}")
          val nextEndIndex =
            if (subStr.head == str.charAt(endIndex)) endIndex else endIndex + 1

          println(s"nextEndIndex: ${nextEndIndex}")
          println(
            s"next subString: ${str.substring(nextStartIndex, nextEndIndex)}"
          )
          val mx = str.substring(nextStartIndex, nextEndIndex).length
          println(s"next max substring: ${Math.max(mx, maxSubstring)}")
          longestSubstringFinder(
            str,
            nextStartIndex,
            nextEndIndex,
            Math.max(mx, maxSubstring)
          )
        }
      } else { maxSubstring }
    }
    if (strLength <= 1) strLength
    else
      longestSubstringFinder(
        str,
        startIndex = 0,
        endIndex = 1,
        maxSubstring = 1
      )
  }
}
