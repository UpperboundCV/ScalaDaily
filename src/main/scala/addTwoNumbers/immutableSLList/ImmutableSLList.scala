package addTwoNumbers.immutableSLList

//https://www.youtube.com/watch?v=b0koYMOqpQk&list=PLLMXbkbDbVt8JLumqKj-3BlHmEXPIfR42&index=186
import scala.collection.immutable.LinearSeq

sealed trait ImmutableSLList[+A] extends LinearSeq[A] {
  def ::[B >: A](elem: B): ImmutableSLList[B] = new ListNode(elem, this)
  override def iterator: Iterator[A] =
    new Iterator[A] {
      var rover: LinearSeq[A] = ImmutableSLList.this
      def hasNext = !rover.isEmpty
      def next: A = {
        val ret = rover.head
        rover = rover.tail
        ret
      }
    }
}

final class ListNode[A](
    override val head: A,
    override val tail: ImmutableSLList[A]
) extends ImmutableSLList[A] {
  override def length: Int = 1 + tail.length
  override def apply(index: Int): A = if (index == 0) head else tail(index - 1)
  override def isEmpty = false
}

object MyNil extends ImmutableSLList[Nothing] {
  override def length = 0
  override def apply(index: Int) =
    throw new IllegalArgumentException("Can't index Nil")
  override def isEmpty = true
  override def head =
    throw new IllegalArgumentException("Can't get the head of Nil")
  override def tail =
    throw new IllegalArgumentException("Can't get the tail of Nil")
}
