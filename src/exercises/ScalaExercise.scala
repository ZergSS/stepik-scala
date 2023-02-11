package exercises

import scala.annotation.tailrec

object ScalaExercise {
  def main(args: Array[String]): Unit = {
    exercise4()
  }

  def exercise1(): Unit ={
    /*
    Исправьте код
    Ваша цель - заставить функцию someFunc всегда выдавать результат умножения x на 2.

    def aCondition(): Boolean = if (1 > 2) true else false

    def someFunnc(x: Int, y: Int): Unit = {
      if (aCondition) x * 3
      else multiply(y)
    }
     */

    def aCondition(): Boolean = true

    def someFunc(x: Int, y: => Int): Int = {
      x * 2
    }
  }

  def exercise2(arg: BigInt): Unit = {
    // Напишите функцию powerOfTwo, вычисляющую степень двойки.

    def powerOfTwo(n: BigInt): BigInt = {
      @tailrec
      def loop(num: BigInt = n, accum: BigInt = 1): BigInt = {
        if (num == 0) accum
        else loop(num - 1, accum * 2)
      }

      loop()
    }

    println(powerOfTwo(arg))
  }

  def exercise3(): Unit = {
    /*
    Попрактикуемся еще, чтобы уж точно набить руку.

    От вас требуется написать программу, которая:

    - увеличивает заданное число x на число y n-ое количество раз
    - выводит на экран полученное на шаге 1 число столько раз, сколько в нем цифр, и фразу is the result
     */

    val fArgs: Array[Int] = Array(10, 1, 5)

    def fun(x: Int, y: Int, n: Int): Int = {
      @tailrec
      def loop(y: Int = y, n: Int = n, accum: Int = x): Int = {
        if (n == 0) accum
        else loop(y, n - 1, accum + y)
      }

      loop()
    }

    val res = fun(fArgs(0), fArgs(1), fArgs(2))
    val len = res.toString.length()

    println(((res.toString :+ ' ') * len) ++ "is the result")
  }

  def exercise4(): Unit = {
    /*
    От вас требуется модифицировать поданную на вход строку так, чтобы слова в ней разместились в обратном порядке.
    Например, строка I like     Scala должна трансформироваться в Scala like I

    Как вы уже могли заметить, в результирующей строке слова разделены одиночным пробелом,
    так что не забудьте предусмотреть удаление всех лишних пробелов из исходной строки.
    Проверьте, чтобы в начале и конце строки пробелов вообще не было.
     */

    def fun(input: String): String = input.split(" ").filter(s => s.nonEmpty).reverse.mkString("", " ", "")

    println(fun("I like    Scala"))
  }

  def exercise5(): Unit = {
    /*
    Примечания:

    от вас требуется написать лишь код классов. Создавать экземпляры классов и что-то принтить не надо
    чтобы ваш код успешно прошел тесты - позаботьтесь, чтобы releaseYear был доступен даже вне тела класса


    Instructor: id, name, surname

    Методы класса:

    - fullName: возвращает полное имя в виде Имя Фамилия.

    первые буквы имени и фамилии обязательно должны быть заглавными, изменять регистр остальных букв не требуется



    Course: courseID, title, releaseYear, instructor

    Методы класса:
    - getID: возвращает id в формате courseID + instructor.id (например, если courseId = 1, а instructor.id = 2, то метод вернет 12)
    - isTaughtBy(instructor): проверяет, является ли указанный человек инструктором курса
    - copyCourse(newReleaseYear): возвращает новый экземпляр класса Course с обновленным значением поля releaseYear
     */

    class Instructor(val id: Int, val name: String, val surname: String) {
      def fullName(): String = correctInfo(name) ++ " " ++ correctInfo(surname)

      private def correctInfo(info: String): String = info.substring(0, 1).toUpperCase() ++ info.substring(1)
    }

    class Course(val courseID: Int, val title: String, val releaseYear: String, val instructor: Instructor) {
      def getID(): String = courseID.toString ++ instructor.id.toString

      def isTaughtBy(instructor: Instructor): Boolean = this.instructor == instructor

      def copyCourse(newReleaseYear: String): Course = new Course(this.courseID, title, newReleaseYear, instructor)
    }
  }
}
