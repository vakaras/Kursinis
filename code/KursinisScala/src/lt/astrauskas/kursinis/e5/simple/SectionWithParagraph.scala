package lt.astrauskas.kursinis.e5.simple

import lt.astrauskas.kursinis.e5.interfaces

trait SectionWithParagraph extends interfaces.Section {

  class Paragraph(val text: String) extends Element {
  }

  def addParagraph(text: String): Paragraph = {
    println("\\\\cite\\{\\w+\\}".r.findAllIn(text).reduceLeft(
        (a: String, b) => a + b))
    return new Paragraph(text)
  }

}