package lt.astrauskas.kursinis.e5.simple

import scala.collection.mutable
import lt.astrauskas.kursinis.e5.interfaces

trait ArticleWithBibliography {

  class Bibliography extends interfaces.Bibliography {

    protected class Entry(
        val authors: mutable.Set[String],
        val title: String,
        val year: Int
        ) {
    }

    protected val entries: mutable.Map[String, Entry] = (
        new mutable.HashMap[String, Entry])

    def createReference(entry: Entry): String = {
      val authors = entry.authors.reduceLeft(
          (authors: String, author: String) => authors + author.charAt(0))
      return "[%s%d]".format(authors, entry.year % 100)
    }

    def cite(id: String): String = entries.get(id) match {
      case Some(entry) => createReference(entry)
      case None => "[Error]"
    }

    def add(
        id: String, authors: mutable.Set[String],
        title: String, year: Int): Unit = {
      val entry = new Entry(authors, title, year)
      entries.update(id, entry)
    }

  }

  protected val bibliographyManager = new Bibliography

  def bibliography: Bibliography = bibliographyManager

}