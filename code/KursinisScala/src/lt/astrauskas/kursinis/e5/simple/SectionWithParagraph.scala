package lt.astrauskas.kursinis.e5.simple

import lt.astrauskas.kursinis.e5.interfaces
import scala.collection.mutable

trait SectionWithParagraph extends interfaces.Section {

  protected val citationRe = "\\\\cite\\{\\w+\\}".r

  protected type ParagraphType <: Paragraph

  class Paragraph(
      val text: String,
      val citations: Set[String]
      ) extends Element {
  }

  protected def createParagraph(
      text: String, citations: Set[String]
      ): ParagraphType
//  protected def createParagraph(
//      text: String, citations: Set[String]
//      ): ParagraphType = (
//      new Paragraph(text, citations))

  def addParagraph(text: String): ParagraphType = {
    val citations = citationRe.findAllIn(text).map(
        (citation: String) => citation.slice(6, citation.length()-1)
          ).toSet
    val paragraph = createParagraph(text, citations)
    // FIXME: Nesikompiliuoja body += paragraph
    return paragraph
  }

}