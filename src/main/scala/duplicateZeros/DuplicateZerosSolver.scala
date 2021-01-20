package duplicateZeros

import addTwoNumbers.immutableSLList.{ListNode, MyNil}
import duplicateZeros.DuplicateZerosSolver.duplicateZeros

/*Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place, do not return anything from your function.*/
/*Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]*/
/*Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]*/
/*Note:
1 <= arr.length <= 10000
0 <= arr[i] <= 9*/
object DuplicateZerosSolver {
  def duplicateZeros(arr: Array[Int]): Array[Int] = {
    def arraytoInt(arr: Array[Int]): Int = {
      arr.toSeq
        .map { i => i.toString }
        .reduce(_ + _)
        .replace("0", "00")
        .substring(0, arr.length)
        .toInt
    }
    val addedZerosNumber = arraytoInt(arr)
    println(addedZerosNumber)
    (arr.size - 1 to 0 by -1)
      .map(i => (addedZerosNumber / math.pow(10, i) % 10).toInt)
      .toArray
  }

}

object Runner {
  def main(args: Array[String]): Unit = {
    val input = Array(1, 0, 2, 3, 0, 4, 5, 0)
    println(duplicateZeros(input).mkString(","))
  }
}
