package lt.astrauskas.kursinis.e5.writers

import lt.astrauskas.kursinis.e5.interfaces
import scala.collection.mutable

trait WithXML {
  def asXML(): scala.xml.Elem
}

trait XMLArticle extends interfaces.Article {

  def sections: mutable.MutableList[
    _ <: interfaces.Section with XMLSection]
  def asXML() = {
    <article>
      <title>{title}</title>
      <authors>
        {
          for (author <- authors) yield
          <author>{author}</author>
        }
      </authors>
      <sections>
        {
          for (section <- sections) yield
            section.asXML()
        }
      </sections>
    </article>
  }
trait XMLSection extends interfaces.Section {

  def title(): String

  trait XMLParagraph extends WithXML {
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
      <content>
        {
          for (element <- body)
            element.asXML()
        }
      </content>
    </section>
  }
  def body: mutable.MutableList[_ <: Element with WithXML]
  def bibliography: interfaces.Bibliography

}
}