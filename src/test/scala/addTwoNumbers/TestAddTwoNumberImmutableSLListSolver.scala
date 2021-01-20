package addTwoNumbers

import addTwoNumbers.immutableSLList.{ListNode, MyNil}
import addTwoNumbers.immutableSLList.SolveAddTwoNumberImmutableSLList.addTwoNumbers
import org.scalatest.FunSuite

class TestAddTwoNumberImmutableSLListSolver extends FunSuite {
  test("1") {
    //  Input: l1 = [2,4,3], l2 = [5,6,4]
    //  Output: [7,0,8]
    //  Explanation: 342 + 465 = 807.
    val l1 = new ListNode[Int](3, MyNil).::(4).::(2)
    val l2 = new ListNode[Int](4, MyNil).::(6).::(5)
    val expected = new ListNode[Int](8, MyNil).::(0).::(7)
    assert(addTwoNumbers(l1, l2).iterator.toSeq === expected.iterator.toSeq)
  }
  test("2") {
    //  Input: l1 = [0], l2 = [0]
    //  Output: [0]
    val l1 = new ListNode[Int](0, MyNil)
    val l2 = new ListNode[Int](0, MyNil)
    val expected = new ListNode[Int](0, MyNil)
    assert(addTwoNumbers(l1, l2).iterator.toSeq === expected.iterator.toSeq)
  }
  test("3") {
    //  Input: l1 = [9,9,9, 9,9,9, 9], l2 = [9,9,9,9]
    //  Output: [8,9,9,9,0,0,0,1]
    val l1 = new ListNode[Int](9, MyNil).::(9).::(9).::(9).::(9).::(9).::(9)
    val l2 = new ListNode[Int](9, MyNil).::(9).::(9).::(9)
    val expected =
      new ListNode[Int](1, MyNil).::(0).::(0).::(0).::(9).::(9).::(9).::(8)
    assert(addTwoNumbers(l1, l2).iterator.toSeq === expected.iterator.toSeq)
  }
}
