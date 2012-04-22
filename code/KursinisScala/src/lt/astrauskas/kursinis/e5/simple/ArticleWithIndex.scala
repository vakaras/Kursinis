package lt.astrauskas.kursinis.e5.simple

import scala.collection.mutable
import lt.astrauskas.kursinis.e5.interfaces

trait ArticleWithIndex {

  type Element <: interfaces.BaseElement

  class Index extends interfaces.Index {

    type Element = ArticleWithIndex.this.Element

    protected val references: mutable.Map[String, Element] = (
        new mutable.HashMap[String, Element])

    def addLabel(id: String, element: Element): Unit = {
      references.update(id, element)
    }

    def reference(id: String): String = references.get(id) match {
      case Some(element) => element.reference()
      case None => "[ERROR]"
    }

  }

  protected val indexManager = new Index

  def index: Index = indexManager

}