package addTwoNumbers.immutableSLList

import scala.annotation.tailrec

//https://www.youtube.com/watch?v=b0koYMOqpQk&list=PLLMXbkbDbVt8JLumqKj-3BlHmEXPIfR42&index=186
//https://leetcode.com/problems/add-two-numbers/
//Definition for singly-linked list.
// class ListNode(_x: Int = 0, _next: ListNode = null) {
//   var next: ListNode = _next
//   var x: Int = _x
// }

object SolveAddTwoNumberImmutableSLList {
  def addResult(
      prevSum: ImmutableSLList[Int],
      addedNum: Int
  ): ImmutableSLList[Int] = {
    val elemList: Seq[Int] = {
      (0 to prevSum.size - 1).map { i => prevSum(i) } :+ addedNum
    }.reverse
//    println(s"element size: ${elemList.size}")
    @tailrec
    def constructListNode(
        listNode: ImmutableSLList[Int],
        index: Int
    ): ImmutableSLList[Int] = {
      if (index < elemList.size - 1) {
//        println(s"index: ${index.toString}")
        constructListNode(listNode.::(elemList(index + 1)), index + 1)
      } else
        listNode
    }
    constructListNode(new ListNode(elemList.head, MyNil), 0)
  }

  def addTwoNumbers(
      l1: ImmutableSLList[Int],
      l2: ImmutableSLList[Int]
  ): ImmutableSLList[Int] = {
    //get size from l1
    @tailrec
    def addNextSum(
        e1: ImmutableSLList[Int],
        e2: ImmutableSLList[Int],
        prevSum: ImmutableSLList[Int],
        carry: Int,
        index: Int
    ): ImmutableSLList[Int] = {
      val temp_index = index + 1
      if (temp_index >= e1.size && temp_index >= e2.size) {
        if (carry == 1) addResult(prevSum, carry) else prevSum
      } else if (temp_index >= e1.size && temp_index < e2.size) {
        val resultSum = e2(temp_index) + carry
        val addValue = resultSum % 10
        val carryI = if (resultSum < 10) 0 else 1
        addNextSum(
          e1,
          e2,
          addResult(prevSum, addValue),
          carryI,
          temp_index
        )
      } else if (temp_index < e1.size && temp_index >= e2.size) {
        val resultSum = e1(temp_index) + carry
        val addValue = resultSum % 10
        val carryI = if (resultSum < 10) 0 else 1
        addNextSum(
          e1,
          e2,
          addResult(prevSum, addValue),
          carryI,
          temp_index
        )
      } else {
        val resultSum = e1(temp_index) + e2(temp_index) + carry
        val addValue = resultSum % 10
        val carryI = if (resultSum < 10) 0 else 1
        addNextSum(
          e1,
          e2,
          addResult(prevSum, addValue),
          carryI,
          temp_index
        )
      }
    }
    val resultSum = l1(0) + l2(0)
    val addValue = resultSum % 10
    val carry = resultSum / 10
    addNextSum(
      l1,
      l2,
      new ListNode(addValue, MyNil),
      carry,
      index = 0
    )
  }

}

object ImmutableSLListRunner extends App {
  //construct List node 5->4->3
  val base3 = new ListNode[Int](3, MyNil)
  val myListNode: ImmutableSLList[Int] = base3.::(4).::(5)
  println(myListNode.iterator.toSeq.mkString(" "))
  import SolveAddTwoNumberImmutableSLList._
  val yourListNode: ImmutableSLList[Int] = addResult(myListNode, 1)
  val testListNode = addResult(base3, 1)
  println(testListNode.iterator.toSeq.mkString(" "))
  println(addTwoNumbers(myListNode, yourListNode).iterator.toSeq.mkString(","))

}
