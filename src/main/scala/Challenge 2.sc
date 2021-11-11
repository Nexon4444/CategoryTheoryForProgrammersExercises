//import challenge_2.memo1
import java.lang.Thread.sleep
import scala.util.Random
import scala.collection.mutable
import scala.collection.mutable.Map
import Utils
// (1)
// memoizationFor1Parameter
case class memo1[A, B](f: (A) => B) extends (A => B) {
  private[this] val memoMap: mutable.HashMap[A, B] = mutable.HashMap.empty
  def apply(v1: A): B = memoMap.getOrElseUpdate(v1, f(v1))
}


//better version
def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
  override def apply(key: I) = getOrElseUpdate(key, f(key))
}
def add = (a: Int, b: Int) => a + b
def square = (a: Int) => a * a
def memoSquare = memo1(square)

// (2)
//Cannot memoize a function to produce random vals since it doesn't take params
//def memoizedGenerator = memoize(Random.nextInt())

// (3)
val randGen = (seed: Int) => {
  println("initializing random generator")
  Random(seed).nextInt
}
def memoGen = memo1(randGen)

//Random(seed).nextInt
//Random(seed).nextInt
val ran1 = memoGen(1)
val ran2 = memoGen(1)

//(4)

val fact = (n: Int) => (1 to n).product
val memoFact = memoize(fact)
Utils.time(memoFact(10))
Utils.time(memoFact(10))
Utils.time(memoFact(10))
Utils.time(fact(10))
Utils.time(fact(10))
Utils.time(fact(10))
//memoFact(100)

//(5)
def f1 = (_: Boolean) => true
def f2 = (_: Boolean) => false
def f3 = (a: Boolean) => a
def f4 = (a: Boolean) => !a