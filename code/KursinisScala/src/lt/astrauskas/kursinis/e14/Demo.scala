package lt.astrauskas.kursinis.e14
class Element {
  def show(): String = "Element."
}
trait AbstractFactory {
  type ElementType                      // Abstraktus tipas.
  def createElement(): ElementType
}
class ConcreteFactory extends AbstractFactory {
  type ElementType = Element            // Tipo konkretizacija.
  def createElement(): ElementType = new Element()
}
object Demo {
  def main(args: Array[String]): Unit = {
    val factory = new ConcreteFactory()
    val element = factory.createElement()
    println(element.show())
  }
}