package lt.astrauskas.kursinis.e5

import scala.collection.mutable

object Demo {

  def main(args: Array[String]): Unit = {
    val article = new simple.Article(
        "Komponentinis programavimas su Scala",
        mutable.HashSet("Vytautas Astrauskas"))
    article.bibliography.add(
        "szyperski02", mutable.HashSet("Clemens Szyperski"),
        "Component Software, Beyond Object-Oriented Programming", 2002)
    article.bibliography.add(
        "scalable05", mutable.HashSet("Martin Odersky", "Matthias Zenger"),
        "Scalable Component Abstractions", 2005)
    val section1 = article.addSection(
        "Objektiškai orientuotas programavimas")
    val section2 = article.addSection(
        "Komponentiškai orientuotas programavimas")
    val paragraph1 = section1.addParagraph("""
Labas rytas. Aš cituoju \cite{szyperski02} ir \cite{scalable05}.
""")
    println(article.asXML())
  }

}