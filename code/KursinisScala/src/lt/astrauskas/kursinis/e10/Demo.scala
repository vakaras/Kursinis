package lt.astrauskas.kursinis.e10
import scala.collection.mutable.HashMap
trait CachedCalculation {
  type KeyType                          // Abstraktus tipas.
  type ValueType                        // Abstraktus tipas.
  private val cache = new HashMap[KeyType, ValueType]
  def calculate(key: KeyType): ValueType
                                        // Abstraktus metodas.
  def lookup(key: KeyType): ValueType = {
    cache.get(key) match {
      case Some(value) => return value
      case None => {
        val value = calculate(key)
        cache.update(key, value)
        return value
      }
    }
  }
}
trait Factorial {
  type KeyType = Int
  type ValueType = Int
  def calculate(key: KeyType): ValueType = {
    println("Calculating " + key)
    if (key == 1)
      return 1
    else
      return lookup(key - 1) * key
  }
  def lookup(key: KeyType): ValueType   // Abstraktus metodas.
}
class CachedFactorial extends CachedCalculation with Factorial {}
object Demo {
  def main(args: Array[String]): Unit = {
    val cf = new CachedFactorial()
    println("3! = " + cf.lookup(3))
    println("5! = " + cf.lookup(5))
  }
}