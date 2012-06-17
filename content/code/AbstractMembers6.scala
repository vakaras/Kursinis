scala> import lt.astrauskas.kursinis.e14
import lt.astrauskas.kursinis.e14

scala> val factory = new e14.ConcreteFactory()
factory: lt.astrauskas.kursinis.e14.ConcreteFactory = \
  lt.astrauskas.kursinis.e14.ConcreteFactory@...

scala> val element: factory.ElementType = factory.createElement()
element: factory.ElementType = \
  lt.astrauskas.kursinis.e14.Element@...

scala> println(element.show())
Element.

