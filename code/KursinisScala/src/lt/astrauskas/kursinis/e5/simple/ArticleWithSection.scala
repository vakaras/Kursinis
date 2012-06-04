package lt.astrauskas.kursinis.e5.simple

import scala.collection.mutable
import lt.astrauskas.kursinis.e5.interfaces

trait ArticleWithSection {

  protected type SectionType <: Section

  class Section(val title: String) extends interfaces.Section {

    protected type ElementType <: Element
    protected val subsectionsList = new mutable.MutableList[SectionType]
    protected val elementsList = new mutable.MutableList[ElementType]

    def subsections = subsectionsList
    def body: mutable.MutableList[ElementType] = elementsList
    def addSubsection(title: String): SectionType = {
      val section = createSection(title)
      subsectionsList += section
      return section
    }
    def bibliography = ArticleWithSection.this.bibliography
    def index = ArticleWithSection.this.index
    protected def getReference(element: Element) = {
      "%s.%d".format(
          "unknown",
          elementsList.indexWhere((p: Element) => p == element))
    }

  }

  protected def createSection(title: String): SectionType

  val sectionsList = new mutable.MutableList[SectionType]

  def bibliography: interfaces.Bibliography
  def index: interfaces.Index
  def sections = sectionsList
  def addSection(title: String): SectionType = {
    val section = createSection(title)
    sections += section
    return section
  }

}