package lt.astrauskas.kursinis.e4

import scala.collection.mutable.ArrayBuffer

class Container(val name: String) {
  val elements = new ArrayBuffer[Element]
  class Element(val name: String) {
    elements.append(this)
    def fullname = "%s.%s".format(Container.this.name, name)
  }
}

object Demo {

  def show(container: Container) = {
    println("name: %s size: %d elements:".format(
        container.name, container.elements.size))
    for (element <- container.elements) {
      println("  %s".format(element.fullname))
    }
  }

  def main(args: Array[String]): Unit = {
    val c1 = new Container("1")
    val c2 = new Container("2")
    show(c1)
    show(c2)
    new c1.Element("a")
    new c1.Element("b")
    new c2.Element("A")
    show(c1)
    show(c2)
  }

}