package lt.astrauskas.kursinis.e5

import scala.collection.mutable

object Demo {

  def main(args: Array[String]): Unit = {
    val article = new simple.Article(
        "Komponentinis programavimas su Scala",
        mutable.HashSet("Vytautas Astrauskas"))
    val section1 = article.addSection(
        "Objektiškai orientuotas programavimas")
    val section2 = article.addSection(
        "Komponentiškai orientuotas programavimas")
        section1.addParagraph("""
Labas rytas. Aš cituoju \\cite{lamb434} ir \\cite{pri3432},
o kitoje eilutėje \\cite{vdi3434}.
""")
    println(article.asXML())
  }

}