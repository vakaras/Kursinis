package lt.astrauskas.kursinis.e5.simple

import lt.astrauskas.kursinis.e5.interfaces
import lt.astrauskas.kursinis.e5.writers
import scala.collection.mutable

class Article(
    articleTitle: String,
    val articleAuthors: mutable.HashSet[String])
    extends interfaces.Article
    with ArticleWithBibliography
    with ArticleWithIndex
    with ArticleWithSection
    with writers.Article {

  class Section(title: String)
    extends super.Section(title)
    with SectionWithParagraph
    with writers.SectionWithParagraph {

    class Paragraph(text: String, citations: Set[String])
      extends super.Paragraph(text, citations)
      with XMLParagraph {
    }

    protected def createParagraph(
        text: String, citations: Set[String]
        ): Paragraph = (
      new Paragraph(text, citations))
    protected override type ParagraphType = Paragraph

  }
  protected override type SectionType = Section
  protected def createSection(title: String): SectionType = {
    return new Section(title)
  }

  def authors = articleAuthors
  def title = articleTitle

}