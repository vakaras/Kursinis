package lt.astrauskas.kursinis.e5.interfaces

import scala.collection.mutable

trait Bibliography {
  def cite(id: String): String
  def add(
      id: String, authors: mutable.Set[String],
      title: String, year: Int): Unit
}

trait Index {
  type Element <: BaseElement
  def addLabel(id: String, element: Element): Unit
  def reference(id: String): String
}

trait BaseElement {
  def reference(): String
}

trait Section {

  trait Element extends BaseElement {
    def reference(): String = getReference(this)
  }

  protected def getReference(element: Element): String
  def subsections: mutable.MutableList[_ <: Section]
  def body: mutable.MutableList[_ <: Element]
  def addSubsection(title: String): Section
}

trait Article {

  def authors: mutable.Set[String]
  def title: String
  def sections: mutable.MutableList[_ <: Section]
  def bibliography: Bibliography
  def index: Index

  def addSection(title: String): Section

}