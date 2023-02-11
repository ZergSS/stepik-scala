package lectures

import scala.Byte.MaxValue
import scala.Double.MaxValue
import scala.annotation.tailrec

object BasicsLesson {
  def main(args: Array[String]): Unit = {
    val varWithoutType = "Auto typed"

    val stringVar : String = "Hello world"
    val charVar : Char = 'C'

    val intVar = 1
    val longVar = 11L

    val floatVar = 11.0f
    val doubleVar = 11.0

    val booleanVar = true

    println(stringVar.getClass)

    println(factorialWithTailRecursion(10))
    println(repeatWord("Nice", 10))
  }

  def valVsVar(): Unit ={
    val immutableVariable = "Hello"
    // immutableVariable = "Bye" -> ERROR

    var mutableVariable = "Hello"
    mutableVariable = "Bye" // -> SUCCESS
  }

  def stringsConcat(): Unit = {
    println('1' +: "42" :+ '3') // -> 1423
    println('a' +: "bc" :+ 'd') // -> abcd
    println("a" ++ "bc" :++ "d") // -> abcd
  }

  def stringInterpolation(): Unit = {
    val name = "John"
    val surname = "Smith"

    // s-interpolator
    println(s"Hello, $name") // Hello, John
    println(s"Hello, ${name + " " + surname}") // Hello, John Smith

    val someString = "This is \n a string"

    // raw-interpolator
    println(raw"This is \n a string") // -> This is \n a string
    println(raw"$someString") // -> This is
                              //     a string
  }

  def codeBlock(): Unit ={
    val codeBlock = {
      val double1 = math.random()
      val double2 = math.random()

      if (~=(double1, double2)) "1" else "2"
    }

    println(codeBlock) // 1 or 2
  }

  def ~=(x: Double, y: Double): Boolean = {
    val precision = 0.004

    if ((x - y).abs < precision) true else false
  }

  def callByNameAndByValue(): Unit ={
    callByValue(System.nanoTime())
    // call by value: x1 = 76291022523800 <- ==
    // call by value: x1 = 76291022523800 <- ==

    callByName(System.nanoTime())
    // call by name: x1 = 76291026117000 <- !=
    // call by name: x1 = 76291026520900 <- !=
    // Выражение вычисляется во время использования в функции, если не используется - не вычисляется
  }

  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec // Для проверки, что это хвостовая рекурсия (можно без аннотации)
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x <= 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n)
  }

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }

    loop(n)
  }
}
