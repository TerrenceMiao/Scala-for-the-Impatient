package org.paradise.scala.chapter02

import org.scalatest.FunSuite

/**
 * Created with IntelliJ IDEA.
 * User: terrence
 * Date: 16/11/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
class testSuite extends FunSuite {

    test("1. The signum of a number is 1 if the number is positive, -1 if it is negative, and 0 if it is zero.") {

        assert (0 == signum(0))
        assert (1 == signum(10))
        assert (-1 == signum(-10))
    }

    test("2. What is the value of an empty block expression {}? What is its type?") {

        val empty = {}
        assert(isUnit(empty))
    }

    test("3. Come up with one situation where the assignment x = y = 1 is valid in Scala.") {

        var y = 2
        val x = y = 1

        assert(y == 1)
        assert(isUnit(x))
    }

    test("4. Write a scala equivalent for the Java loop ...") {

        countDown(10)
    }

    test("5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.") {

        countDown(5)
    }

    test("6. Write a for loop for computing the product of the Unicode codes of all letters in a string") {

        var unicode: Long = 1

        for (s <- "Hello") {
            unicode *= s.toInt
        }

        assert(9415087488L == unicode)
    }

    test("7. Solve the preceding exercise without writing a loop.") {

        assert(9415087488L == "Hello".foldLeft(1L)(_ * _))
    }

    test("8. Write a function product(s : String) that computes the product") {

        assert(9415087488L == product("Hello"))
    }

    test("9. Make the function of the preceding exercise a recursive function.") {

        assert(9415087488L == productRecursive("Hello"))
    }

    test("10. Write a function that computes xn, where n is an integer. Use the following recursive definition:") {

        for(i <- 1 to 20){
            assert(power(5, i) == math.pow(5, i).toLong)
        }
    }

    def signum(n: Int) = {

        if (n > 0) 1 else if (n == 0) 0 else -1
    }

    def isUnit(obj:Any) = obj match {

        case u:Unit => true
        case _ => false
    }

    def countDown(n: Int) = {

        for (i <- n to 0 by -1) {
            println(i)
        }
    }

    def product(s: String) = {

        s.foldLeft(1L)(_ * _)
    }

    def productRecursive(s: String): Long = {

        if (s.length == 0)
            1L
        else {
            println(s(0))
            s(0).toInt * productRecursive(s drop 1)
        }
    }

    def power(x: Int, n: Int): Long = {

        val result =
            if (n == 0)
                1
            else if (n < 0)
                1 / (x * power(x, n - 1))
            else if (n % 2 != 0)
                x * power(x, n - 1)
            else
                power(x, n / 2) * power(x, n / 2)

        result
    }
    
}
