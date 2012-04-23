package lt.astrauskas.kursinis.e5.writers

import lt.astrauskas.kursinis.e5.simple
import lt.astrauskas.kursinis.e5.interfaces

trait SectionWithParagraph {

  def title(): String

  trait XMLParagraph {
    val text: String
    val citations: Set[String]
    def asXML() = {
      <p>
      {
        var buffer = text
        for (citation <- citations) {
          buffer = buffer.replaceAll(
              "\\\\cite\\{%s\\}".format(citation),
              bibliography.cite(citation))
        }
        buffer
      }
      </p>
    }
  }

  def asXML() = {
    <section>
      <title>{title}</title>
    </section>
  }

  def bibliography: interfaces.Bibliography

}