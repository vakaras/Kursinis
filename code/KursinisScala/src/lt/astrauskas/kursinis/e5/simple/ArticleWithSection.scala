package lt.astrauskas.kursinis.e5.simple

import scala.collection.mutable
import lt.astrauskas.kursinis.e5.interfaces

trait ArticleWithSection {

  protected type SectionType <: Section

  class Section(val title: String) extends interfaces.Section {

    protected val subsectionsList = new mutable.MutableList[SectionType]
    protected val elementsList = new mutable.MutableList[Element]

    def subsections = subsectionsList
    def body = elementsList
    def addSubsection(title: String): SectionType = {
      val section = createSection(title)
      subsectionsList += section
      return section
    }
    protected def getReference(element: Element) = {
      "%s.%d".format(
          "unknown",
          elementsList.findIndexOf((p: Element) => p == element))
    }

  }

  protected def createSection(title: String): SectionType

  val sectionsList = new mutable.MutableList[Section]

  def sections = sectionsList
  def addSection(title: String): SectionType = {
    val section = createSection(title)
    sectionsList += section
    return section
  }

}