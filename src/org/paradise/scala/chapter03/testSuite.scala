package org.paradise.scala.chapter03

import org.scalatest.FunSuite
import org.scalatest.Matchers
import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/**
 * Created with IntelliJ IDEA.
 * User: terrence
 * Date: 16/11/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
class testSuite extends FunSuite with Matchers {

    test("1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive)") {

        for (i <- 1 to 10) {
            val array = randomArray(i)
            println(array.toList)
        }
    }

    test("2. Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5)") {

        var array = Array[Int](1, 2, 3, 4, 5)

        Array[Int](2, 1, 4, 3, 5) should equal (swapPlaceArray(array))

        array = Array[Int](1)
        Array[Int](1) should equal (swapPlaceArray(array))

        array = Array[Int](1, 2, 3, 4, 5, 6, 7, 8)
        Array[Int](2, 1, 4, 3, 6, 5, 8, 7) should equal (swapPlaceArray(array))
    }
    
    test("3. Repeat the preceding assignment, but produce a new array with the swapped values") {
        
    }

    def randomArray(n: Int) = {

        for (i <- 0 to n) yield Random.nextInt(n)
    }

    def swapPlaceArray(array: Array[Int]) = {

        (
            for {
                b <- array.grouped(2) // returns Iterable
                c <- b.reverse
            } yield c).toArray
    }

}
