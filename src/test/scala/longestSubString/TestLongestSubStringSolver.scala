package longestSubString

import longestSubstring.LongestSubStringSolver
import org.scalatest.FunSuite

class TestLongestSubStringSolver extends FunSuite {
  test("isUnique returns false when every letter is unique.") {
    assert(LongestSubStringSolver.isUnique("cloth") === true)
  }
  test("isUnique returns true when some letter is duplicated in string") {
    assert(LongestSubStringSolver.isUnique("wood") === false)
  }
  test(
    "getSubStringWithLength returns sequence of substring with specific length"
  ) {
    val str = "HelloWorld"
    assert(
      LongestSubStringSolver
        .getSubStringWithLength(str, str.size - 1) === Seq(
        str.substring(0, str.size - 1),
        str.substring(1)
      )
    )
  }
  test(
    "uniqueSubstringLength returns all unique substring lengths from a string"
  ) {
    val str = "HelloWorld"
    assert(
      LongestSubStringSolver.uniqueSubstringLength(str).head === 5
    )
  }
  test(
    "(1)lengthOfLongestSubstring returns maximum length of unique substring"
  ) {
    val str = "abcabcbb"
    assert(LongestSubStringSolver.lengthOfLongestSubstring(str) === 3)
  }
  test(
    "(2)lengthOfLongestSubstring returns maximum length of unique substring"
  ) {
    val str = "pwwkew"
    assert(LongestSubStringSolver.lengthOfLongestSubstring(str) === 3)
  }
  test(
    "lengthOfLongestSubstring returns 1 when all characters in string are duplicated"
  ) {
    val str = "bbbbb"
    assert(LongestSubStringSolver.lengthOfLongestSubstring(str) === 1)
  }
  test("lengthOfLongestSubstring returns 0 when it is empty string") {
    val str = ""
    assert(LongestSubStringSolver.lengthOfLongestSubstring(str) === 0)
  }
}
