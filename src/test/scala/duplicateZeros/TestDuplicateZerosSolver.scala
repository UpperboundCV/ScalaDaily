package duplicateZeros

import org.scalatest.FunSuite
import duplicateZeros.DuplicateZerosSolver

class TestDuplicateZerosSolver extends FunSuite {
  test(
    "when input is [1,0,2,3,0,4,5,0] duplicate zeros function return [1,0,0,2,3,0,0,4]"
  ) {
    val input = Array(1, 0, 2, 3, 0, 4, 5, 0)
    val actual = DuplicateZerosSolver.duplicateZeros(input)
    val expected = Array(1, 0, 0, 2, 3, 0, 0, 4)
    assert(actual === expected)
  }
}
