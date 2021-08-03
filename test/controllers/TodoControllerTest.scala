package controllers

import cats.Id
import cats.data.OptionT
import org.scalatest.FunSuite

import scala.concurrent.Future

class TodoControllerTest extends FunSuite {

  import cats.syntax.either._

  def parseInt(s: String): Option[Int] = Either.catchOnly[NumberFormatException](s.toInt).toOption

  test("sdfsf") {

    import cats.implicits._

    val value = List("1", "2", "3").map(parseInt)
    val option = for {
      x <- OptionT[List, Int](value)
    } yield x

  }

  test("sfd") {

    import cats.~>
    val first: List ~> Option = new ~>[List, Option] {
      def apply[A](l: List[A]): Option[A] = l.headOption
    }

    val abc: Id ~> Future = new ~>[Id, Future] {
      override def apply[A](fa: Id[A]): Future[A] = Future.successful(fa)
    }
  }

  test("sum of array") {
    val list = List(1, 3, 5, 6, 8)

    list

  }

  //  def fuck(numbers: List[Int]): List[Int] = {
  //
  //    if (numbers.length == 2) {
  //      numbers
  //    } else if (isEven(numbers.length))
  //      1 to (numbers.length / 2)
  //
  //
  //    else {
  //      val middium = numbers.length / 2 + 1
  //      List(numbers.sum - numbers(middium), numbers(middium))
  //
  //    }

}

