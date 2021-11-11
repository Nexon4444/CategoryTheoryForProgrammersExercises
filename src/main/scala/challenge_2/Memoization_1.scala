package challenge_2

import com.sun.org.apache.xml.internal.utils.MutableAttrListImpl

import scala.collection.mutable
import scala.collection.mutable.Map
import scala.util.Random
// (1)
// memoizationFor1Parameter
case class memo1[A, B](f: (A) => B) extends (A => B):
  private[this] val memoMap: mutable.Map[A, B] = Map.empty
  def apply(v1: A): B = memoMap.getOrElseUpdate(v1, f(v1))

//better version
def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
  override def apply(key: I) = getOrElseUpdate(key, f(key))
}

// memoization for multiple parameters
//https://stackoverflow.com/questions/5875767/scala-memoize-a-function-no-matter-how-many-arguments-the-function-takes
//
//sealed class Tupler[U, T](val tupled: U => T,
//                          val untupled: T => U)
//
//trait FunctionDecorator {
//  final def apply[T, R, F](f: F)(implicit e: Tupler[F, T => R]): F =
//    e.untupled(decorate(e.tupled(f)))
//
//  protected def decorate[T, R](f: T => R): T => R
//}
//
//object Memoize extends FunctionDecorator {
//  /**
//   * Memoize a function.
//   *
//   * @param f the function to memoize
//   */
//  protected def decorate[T, R](f: T => R) = new Memoize1(f)
//}



//object memo:
//  def apply[A, B](f: A => B) = new memo[A, B](f)

def strSqLen(s: String) = s.length*s.length

object Memoization_1 extends App {
  def add = (a: Int, b: Int) => a + b
  def square = (a: Int) => a * a
  def memoSquare = memo1(square)
}

//(2)
//Cannot memoize a function to produce random vals since it doesn't take params
//def memoizedGenerator = memoize(Random.nextInt())


//object Memo:
//  def apply[A, B](): Memo[A, B] = new Memo()
  
  
//object Memoizer extends Memoizable[Int, Int]:
//  def apply[A, B](): memoizer = new memoizer()


//val x = memoize(3*2)
//val f:  =
//
